package it.unimol;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Utils
 */
public class Utils {

  public static List<File> getAllJavaFiles(File root) {
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

  public static Optional<String> getFileExtension(String filename) {
    return Optional.ofNullable(filename)
        .filter(f -> f.contains("."))
        .map(f -> f.substring(filename.lastIndexOf(".") + 1));
  }

  public static void createFile(File file, String content) throws IOException {
    if (!file.exists()) {
      file.getParentFile().mkdirs();
      file.createNewFile();
      try (BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()))) {
        bw.write(content);
      } catch (IOException e) {
        throw e;
      }
    }
  }
}
