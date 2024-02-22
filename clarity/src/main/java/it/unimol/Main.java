/* (C)2024 */
package it.unimol;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Main {

  private static final String TEMP_FILE_PATH = "temp" + System.getProperty("file.separator");
  private static final Logger LOGGER = CustomLogger.getInstance().getLogger();
  private static final MethodExtractor methodExtractor = new MethodExtractor();
  private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
  private static final Rsm rsm = new Rsm();

  public static void main(String[] args) {
    for (String filePath : args) {
      File file = new File(filePath);
      LOGGER.info("Processing file: " + file.getPath());

      String projectName = file.getName();
      int rootIndex = filePath.indexOf(projectName);

      List<File> javaFiles = Utils.getAllJavaFiles(file);

      for (File f : javaFiles) {
        List<MethodInfo> methodsInfo = new ArrayList<>();
        try {
          LOGGER.info("Extracting methods...");
          methodsInfo = methodExtractor.extract(f);
        } catch (IOException e) {
          LOGGER.severe("Error extracting methods from file: " + f.getPath() +
              ": " + e.getMessage());
        }

        for (MethodInfo methodInfo : methodsInfo) {
          LOGGER.info("Wrapping method in a temporary file...");

          File tempFile = new File(TEMP_FILE_PATH +
              methodInfo.getRelativePathOfOriginalFile()
                  .substring(rootIndex)
                  .replace(".java", "")
              +
              System.getProperty("file.separator") +
              methodInfo.getName() + ".java");

          try {
            Utils.createFile(tempFile,
                methodExtractor.wrapAsSnippet(methodInfo));
          } catch (IOException e) {
            LOGGER.severe("Error during file creation: " +
                tempFile.getAbsolutePath() + ": " + e.getMessage());
          }

          LOGGER.info("Serializing methods additional informaton...");
          try {
            String json = gson.toJson(methodInfo);
            Utils.createFile(
                new File(tempFile.getAbsolutePath().replace(".java", ".json")),
                json);
          } catch (JsonIOException | IOException e) {
            LOGGER.severe("Error during serialization of method info: " +
                methodInfo.getName() + ": " + e.getMessage());
          }

          LOGGER.info("Analyzing method: " + methodInfo.getName());
          double score = rsm.analyze(Path.of(tempFile.getPath()));
          LOGGER.info("Score: " + score);
        }
      }
    }
  }
}
