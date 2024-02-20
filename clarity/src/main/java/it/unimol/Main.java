/* (C)2024 */
package it.unimol;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Main {

  private static final String TRAIL_CHARACHTER = System.getProperty("os.name") == "Windows" ? "\\" : "/";
  private static final String TEMP_FILE_PATH = "temp" + TRAIL_CHARACHTER;
  private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
  private static final MethodExtractor methodExtractor = new MethodExtractor();

  public static void main(String[] args) {
    for (String filePath : args) {
      File file = new File(filePath);
      LOGGER.info("Processing file: " + file.getPath());

      String projectName = file.getName();
      List<File> javaFiles = Utils.getAllJavaFiles(file);

      for (File f : javaFiles) {
        int rootIndex = f.getPath().indexOf(projectName);

        List<MethodInfo> methodsInfo = new ArrayList<>();

        try {
          LOGGER.info("Extracting methods from file: " + f.getPath());
          methodsInfo = methodExtractor.extract(f);
        } catch (IOException e) {
          LOGGER.severe("Error extracting methods from file: " + f.getPath() +
              ": " + e.getMessage());
        }

        for (MethodInfo methodInfo : methodsInfo) {
          LOGGER.info("Creating temp file for method: " + methodInfo.getName());
          File tempFile = new File(TEMP_FILE_PATH +
              Utils.removeExtension(
                  methodInfo.getOriginFile().getPath().substring(
                      rootIndex))
              +
              TRAIL_CHARACHTER,
              methodInfo.getName() + ".java");

          try {
            Utils.createFile(tempFile,
                methodExtractor.wrapAsSnippet(methodInfo));
          } catch (IOException e) {
            LOGGER.severe("Error creating temp file for method: " +
                tempFile.getAbsolutePath() + ": " + e.getMessage());
          }
        }
      }
    }
  }
}
