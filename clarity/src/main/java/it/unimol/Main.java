/* (C)2024 */
package it.unimol;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.temporal.TemporalField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Main {

  private static final String TEMP_FILE_PATH = System.getProperty("os.name") == "Windows" ? "temp\\" : "temp/";
  private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
  private static final MethodExtractor methodExtractor = new MethodExtractor();

  public static void main(String[] args) {
    for (String filePath : args) {
      File file = new File(filePath);
      LOGGER.info("Processing file: " + file.getPath());

      String projectName = file.getName();
      List<File> javaFiles = getAllJavaFiles(file);

      for (File f : javaFiles) {
        int rootIndex = f.getPath().indexOf(projectName);
        LOGGER.info("A");

        List<MethodInfo> methodsInfo = new ArrayList<>();

        try {
          LOGGER.info("Extracting methods from file: " + f.getPath());
          methodsInfo = methodExtractor.extract(f);
        } catch (IOException e) {
          e.printStackTrace();
        }

        for (MethodInfo methodInfo : methodsInfo) {
          LOGGER.info("Creating temp file for method: " + methodInfo.getName());
          File tempFile = new File(TEMP_FILE_PATH +
              removeExtension(
                  methodInfo.getOriginFile().getPath().substring(
                      rootIndex))
              +
              "/",
              methodInfo.getName() + ".java");
          System.out.println(tempFile.getAbsolutePath());

          if (!tempFile.exists()) {
            try {
              tempFile.getParentFile().mkdirs();
              tempFile.createNewFile();
              BufferedWriter bw = new BufferedWriter(
                  new FileWriter(tempFile.getAbsoluteFile()));
              bw.write(wrapAsSnippet(methodInfo.getBody(),
                  methodInfo.getDeclaration()));
              bw.close();
            } catch (IOException e) {
              LOGGER.warning(
                  "Error creating file: " + tempFile.getAbsolutePath() + ": " +
                      e.getMessage());
            }
          }
        }
      }
    }
  }

  private static List<File> getAllJavaFiles(File root) {
    List<File> java_files = new ArrayList<>();
    if (root.isDirectory()) {
      List<File> subFiles = Arrays.asList(root.listFiles());
      subFiles.forEach(f -> {
        java_files.addAll(getAllJavaFiles(f));
      });
    }

    Optional<String> extension = getFileExtension(root.getPath());
    if (!extension.isPresent() || extension.isEmpty() ||
        !extension.get().equals("java")) {
      return java_files;
    }

    java_files.add(root);
    return java_files;
  }

  private static String removeExtension(String filename) {
    return filename.replaceFirst("[.][^.]+$", "");
  }

  private static Optional<String> getFileExtension(String filename) {
    return Optional.ofNullable(filename)
        .filter(f -> f.contains("."))
        .map(f -> f.substring(filename.lastIndexOf(".") + 1));
  }

  // TODO: move to method extractor
  private static String wrapAsSnippet(String body, String declaration) {
    String nonFormattedMethod = declaration + body;
    assert (!nonFormattedMethod.isEmpty() && nonFormattedMethod.contains("\n"));

    String spaces = nonFormattedMethod.split("\n")[0].replaceAll("[^ ]", "");
    StringBuilder method = new StringBuilder("");
    for (String str : nonFormattedMethod.split("\n")) {
      method.append(spaces + str + "\n");
    }
    return "class Snippet {\n" + method + "}";
  }

}
