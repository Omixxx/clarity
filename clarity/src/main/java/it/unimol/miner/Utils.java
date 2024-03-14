package it.unimol.miner;

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

  public static List<File> getAllFilesFromARoot(File root, String extension) {
    List<File> files = new ArrayList<>();
    if (root.isDirectory()) {
      List<File> subFiles = Arrays.asList(root.listFiles());
      subFiles.forEach(
          f -> {
            files.addAll(getAllFilesFromARoot(f, extension));
          });
    }

    Optional<String> currentFileExtension = getFileExtension(root.getPath());
    if (!currentFileExtension.isPresent() || currentFileExtension.isEmpty() ||
        !currentFileExtension.get().equals(
            extension.strip().replace(".", ""))) {
      return files;
    }
    files.add(root);
    return files;
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

  public static boolean isOdd(int number) {
    return number % 2 != 0;
  }

  public static boolean isEven(int number) {
    return number % 2 == 0;
  }
}
