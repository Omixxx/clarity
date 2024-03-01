package it.unimol.Miner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
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
    int rootIndex = file.getPath().indexOf(projectName);

    List<File> javaFiles = Utils.getAllFilesFromARoot(file, "java");

    for (File f : javaFiles) {

      System.out.println("\n---------------------[" + f.getName() +
          "]--------------------\n");
      List<MethodInfo> methodsInfo = new ArrayList<>();
      try {
        LOGGER.info("Extracting methods ⛏️");
        methodsInfo = methodExtractor.extract(f);
      } catch (IOException e) {
        LOGGER.error("Error extracting methods from file: " + f.getPath() +
            ": " + e.getMessage());
      }

      for (MethodInfo methodInfo : methodsInfo) {
        LOGGER.info("Wrapping method " + methodInfo.getName() +
            " in a temporary file");

        File tempFile = new File(TEMP_FILE_PATH +
            methodInfo.getRelativePathOfOriginalFile()
                .substring(rootIndex)
                .replace(".java", "")
            +
            System.getProperty("file.separator") +
            methodInfo.getName() + ".java");

        if (tempFile.exists()) {
          LOGGER.info("file " + tempFile.getName() + " already exists");
          continue;
        }

        try {
          Utils.createFile(tempFile, methodExtractor.wrapAsSnippet(methodInfo));
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

  public void resultFilter(int percentageOfTheWorst, int percentageOfTheBest,
      int percentageOfTheMiddle) {

    Path projectsResultsPath = Path.of(TEMP_FILE_PATH);
    for (File file : projectsResultsPath.toFile().listFiles()) {

      assert file != null : "File cannot be null! Nothing to do.";

      HashMap<File, MethodInfo> metrics = new HashMap<>();
      List<File> files = Utils.getAllFilesFromARoot(file, "json");
      int numberOfWorstFilesToKeep = files.size() * percentageOfTheWorst / 100;
      int numberOfBestFilesToKeep = files.size() * percentageOfTheBest / 100;
      int numberOfMidFilesToKeep = (numberOfBestFilesToKeep + numberOfWorstFilesToKeep) / 2;

      LOGGER.info("Cleaning irrelevant files 🧹");
      for (File f : files) {
        try {
          String content = Files.readString(Path.of(f.getAbsolutePath()));
          metrics.put(f, gson.fromJson(content, MethodInfo.class));
        } catch (IOException e) {
          LOGGER.error("Error reading file: " + f.getAbsolutePath() + ": " +
              e.getMessage());
          e.printStackTrace();
        }
      }

      List<File> filesToBeDeleted = metrics.entrySet()
          .stream()
          .sorted(Map.Entry.<File, MethodInfo>comparingByValue())
          .map(Map.Entry::getKey)
          .collect(Collectors.toList());

      deleteNonRelevantFiles(filesToBeDeleted, numberOfWorstFilesToKeep,
          numberOfBestFilesToKeep, numberOfMidFilesToKeep);
    }
  }

  private void deleteNonRelevantFiles(List<File> files,
      int numberOfWorstFilesToKeep,
      int numberOfBestFilesToKeep,
      int numberOfMidFilesToKeep) {

    files.subList(0, numberOfWorstFilesToKeep).clear();
    files.subList(files.size() - numberOfBestFilesToKeep, files.size()).clear();
    int mid = files.size() / 2;
    files.subList(mid - numberOfMidFilesToKeep, mid + numberOfMidFilesToKeep)
        .clear();
    files.forEach(f -> {
      LOGGER.info("Deleting file: " + f.getName());
      f.delete();
    });

    LOGGER.info("Cleaning snippet files 🧹");
    Utils.getAllFilesFromARoot(Path.of(TEMP_FILE_PATH).toFile(), "java")
        .forEach(f -> {
          f.delete();
        });
  }
}
