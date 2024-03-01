package it.unimol.Miner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
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
      System.out.println("File cannot be null");
      return;
    }

    LOGGER.info("Processing project: " + file.getPath());

    String projectName = file.getName();
    int rootIndex = file.getPath().indexOf(projectName);

    List<File> javaFiles = Utils.getAllJavaFiles(file);

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
}
