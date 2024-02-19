/* (C)2024 */
package it.unimol;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Main {

  private static final String TEMP_FILE_PATH = "temp";
  private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
  private static final MethodExtractor methodExtractor = new MethodExtractor();

  public static void main(String[] args) {
    for (String filePath : args) {
      File file = new File(filePath);
      LOGGER.info("Processing file: " + file.getPath());

      String projectName = file.getName(); // Ottieni solo il nome del progetto
      getAllJavaFiles(file).forEach(f -> {
        int projectIndex = f.getPath().indexOf(projectName);
        System.out.println(f.getPath().substring(projectIndex));
      });

      String projectTempPath = Paths.get(TEMP_FILE_PATH, projectName).toString();
      // List<MethodInfo> methodsInfo = methodExtractor.extract(file);

      // String projectRootDir = System.getProperty("user.dir");
      // File tempDir = new File(TEMP_FILE_PATH);
      // if (!tempDir.exists()) {
      // tempDir.mkdirs();
      // }
      // System.setProperty("user.dir", tempDir.getAbsolutePath());
      //
      //
      // for (MethodInfo methodInfo : methodsInfo) {
      // try (FileWriter writer = new FileWriter(methodInfo.getName() +
      // ".java")) {
      // writer.write(
      // wrapAsSnippet(methodInfo.getBody(),
      // methodInfo.getDeclaration()));
      // } catch (IOException e) {
      // e.printStackTrace();
      // }
      // }
      // System.setProperty("user.dir", projectRootDir);
    }
  }

  private static List<File> getAllJavaFiles(File rootDir) {
    List<File> java_files = new ArrayList<>();
    if (rootDir.isDirectory()) {
      List<File> subFiles = Arrays.asList(rootDir.listFiles());
      subFiles.forEach(file -> {
        java_files.addAll(getAllJavaFiles(file));
      });
    }

    Optional<String> extension = getFileExtension(rootDir.getPath());
    if (!extension.isPresent() || extension.isEmpty() ||
        !extension.get().equals("java")) {
      return java_files;
    }

    java_files.add(rootDir);
    return java_files;
  }

  private static String[] getSubFilesPaths(List<File> files) {
    return files.stream().map(file -> file.getPath()).toArray(String[]::new);
  }

  private static Optional<String> getFileExtension(String filename) {
    return Optional.ofNullable(filename)
        .filter(f -> f.contains("."))
        .map(f -> f.substring(filename.lastIndexOf(".") + 1));
  }

  private static String wrapAsSnippet(String body, String declaration) {
    String nonFormattedMethod = declaration + body;
    assert (!nonFormattedMethod.isEmpty() && nonFormattedMethod.contains("\n"));

    String spaces = nonFormattedMethod.split("\n")[0].replaceAll("[^ ]", "");
    StringBuilder method = new StringBuilder("");
    for (String str : nonFormattedMethod.split("\n")) {
      method.append(spaces + str + "\n");
    }
    return "class Snippet {\n" + method + "\n}";
  }

  private static String extractRelativePath(String filePath,
      String projectName) {
    Path fullPath = Paths.get(filePath);
    Path projectPath = Paths.get(projectName);

    // Calcola il percorso relativo
    Path relativePath = projectPath.relativize(fullPath);

    // Converte il percorso relativo in una stringa
    return relativePath.toString();
  }
}
