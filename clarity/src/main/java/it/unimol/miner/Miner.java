package it.unimol.miner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import java.io.File;
import java.io.IOException;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Miner
 */
public class Miner {

  private final String TEMP_FILE_PATH = "temp" + System.getProperty("file.separator");
  private final Logger LOGGER = LoggerFactory.getLogger(Miner.class);
  private final MethodExtractor methodExtractor = new MethodExtractor();
  private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
  private final Rsm rsm = new Rsm();

  public void mine(File file) {
    if (file == null) {
      System.out.println("File cannot be null! Nothing to do.");
      return;
    }

    LOGGER.info("Processing project: " + file.getPath());

    String projectName = file.getName();

    List<String> excludedSymbols = List.of("test", "Test", "Tests", "tests", "testing", "Testing");
    List<File> javaFiles = Utils.getAllFilesFromARoot(file, "java", excludedSymbols);

    for (File f : javaFiles) {

      System.out.println("\n---------------------[" + f.getName() +
          "]--------------------\n");
      List<MethodInfo> methodsInfo = new ArrayList<>();
      try {
        LOGGER.info("Extracting methods ⛏️");
        methodsInfo = methodExtractor.extract(f, projectName);
      } catch (IOException e) {
        LOGGER.error("Error extracting methods from file: " + f.getPath() +
            ": " + e.getMessage());
      }

      for (MethodInfo methodInfo : methodsInfo) {
        LOGGER.info("Wrapping method " + methodInfo.getName() +
            " in a temporary file");

        File tempFile = new File(
            TEMP_FILE_PATH + methodInfo.getClassPath().replace(".java", "") +
                System.getProperty("file.separator") + methodInfo.getName() +
                ".java");

        if (tempFile.exists()) {
          LOGGER.info("file " + tempFile.getName() + " already exists");
          continue;
        }

        try {
          Utils.createFile(tempFile, "class Snippet {\n" +
              methodInfo.getMethod() + "\n}");
        } catch (IOException e) {
          LOGGER.error("Error during file creation: " +
              tempFile.getAbsolutePath() + ": " + e.getMessage());
        }

        LOGGER.info("Analyzing method: " + methodInfo.getName());
        double score = rsm.analyze(Path.of(tempFile.getPath()));
        methodInfo.setReadabilityScore(score);
        LOGGER.info("Score: " + score);

        LOGGER.info("Serializing methods additional informaton");
        try {
          String json = gson.toJson(methodInfo);
          Utils.createFile(
              new File(tempFile.getAbsolutePath().replace(".java", ".json")),
              json);
        } catch (JsonIOException | IOException e) {
          LOGGER.error("Error during serialization of method: " +
              methodInfo.getName() + ": " + e.getMessage());
        }
      }
    }
  }

  public void filterResults(int percentageOfTheWorst, int percentageOfTheBest) {

    Path projectsResultsPath = Path.of(TEMP_FILE_PATH);
    for (File file : projectsResultsPath.toFile().listFiles()) {

      assert file != null : "File cannot be null! Nothing to do.";

      HashMap<File, MethodInfo> metrics = new HashMap<>();
      List<File> files = Utils.getAllFilesFromARoot(file, "json", new ArrayList<>());
      int numberOfWorstFilesToKeep = files.size() * percentageOfTheWorst / 100;
      int numberOfBestFilesToKeep = files.size() * percentageOfTheBest / 100;
      int numberOfMidFilesToKeep = (numberOfBestFilesToKeep + numberOfWorstFilesToKeep) / 2;

      LOGGER.info("Number of worst files to keep: " + numberOfWorstFilesToKeep);
      LOGGER.info("Number of best files to keep: " + numberOfBestFilesToKeep);
      LOGGER.info("Number of mid files to keep: " + numberOfMidFilesToKeep);

      LOGGER.info("Cleaning irrelevant files 🧹");
      files.forEach(f -> metrics.put(f, deserialize(f)));

      List<File> sortedFiles = metrics.entrySet()
          .stream()
          .sorted(Map.Entry.<File, MethodInfo>comparingByValue())
          .map(Map.Entry::getKey)
          .collect(Collectors.toList());

      List<File> deletedFiles = deleteNonRelevantFiles(
          new ArrayList<>(sortedFiles), numberOfWorstFilesToKeep,
          numberOfBestFilesToKeep, numberOfMidFilesToKeep);

      List<File> sortedFilesToBeLabled = new ArrayList<>(sortedFiles);
      sortedFilesToBeLabled.removeAll(deletedFiles);

      labelFiles(sortedFilesToBeLabled, numberOfWorstFilesToKeep,
          (sortedFilesToBeLabled.size() - 1) - numberOfBestFilesToKeep);
    }
  }

  private void labelFiles(List<File> files, int endIndexOfTheWorstReadableFiles,
      int startIndexOfTheBestReadableFiles) {

    for (int i = 0; i < files.size(); i++) {
      File f = files.get(i);
      MethodInfo methodInfo = deserialize(f);

      if (i < endIndexOfTheWorstReadableFiles) {
        methodInfo.setReadabilityLabel(ReadabilityLabel.LOW);
      } else if (i > startIndexOfTheBestReadableFiles) {
        methodInfo.setReadabilityLabel(ReadabilityLabel.HIGH);
      } else {
        methodInfo.setReadabilityLabel(ReadabilityLabel.MID);
      }
      try {

        LOGGER.info("Labeling file: " + f.getName() +
            " whit score: " + methodInfo.getReadabilityScore() +
            " as " + methodInfo.getReadabilityLabel());

        f.delete();
        Utils.createFile(f, gson.toJson(methodInfo));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  private List<File> deleteNonRelevantFiles(List<File> files,
      int numberOfWorstFilesToKeep,
      int numberOfBestFilesToKeep,
      int numberOfMidFilesToKeep) {

    files.subList(0, numberOfWorstFilesToKeep).clear();
    files.subList(files.size() - numberOfBestFilesToKeep, files.size()).clear();

    int mid = files.size() % 2 == 0 ? files.size() / 2 : (files.size() - 1) / 2;
    int leftOffset = getLeftOffset(numberOfMidFilesToKeep);
    int rightOffset = numberOfMidFilesToKeep - leftOffset;
    files.subList((mid - leftOffset), (mid + rightOffset)).clear();

    files.forEach(f -> {
      LOGGER.info("Deleting file: " + f.getName());
      f.delete();
    });

    LOGGER.info("Cleaning snippet files 🧹");
    Utils
        .getAllFilesFromARoot(Path.of(TEMP_FILE_PATH).toFile(), "java",
            new ArrayList<>())
        .forEach(f -> {
          f.delete();
        });

    return files;
  }

  public MethodInfo deserialize(File file) {
    assert file != null : "File cannot be null! Nothing to do.";
    MethodInfo methodInfo = null;
    try {
      String content = Files.readString(Path.of(file.getAbsolutePath()));
      methodInfo = gson.fromJson(content, MethodInfo.class);
    } catch (IOException e) {
      LOGGER.error("Error deserializing file: " + file.getAbsolutePath() +
          ": " + e.getMessage());
    }
    return methodInfo;
  }

  private int getLeftOffset(int numberOfMidFilesToKeep) {
    DecimalFormat decimalFormat = new DecimalFormat("#");
    decimalFormat.setRoundingMode(RoundingMode.CEILING);

    if (Utils.isOdd(numberOfMidFilesToKeep)) {

      return (Integer.parseInt(
          decimalFormat.format((numberOfMidFilesToKeep - 1) / 2)));
    }
    return (numberOfMidFilesToKeep - 1) / 2;
  }
}
