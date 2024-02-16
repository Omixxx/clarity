package it.unimol;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class Main {

  private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
  private static final MethodExtractor methodExtractor = new MethodExtractor();

  public static void main(String[] args) throws IOException {
    for (String filePath : args) {
      File file = new File(filePath);
      LOGGER.info("Processing file: " + file.getPath());

      if (file.isDirectory()) {
        List<File> subFiles = Arrays.asList(file.listFiles());
        String[] subFilesPath = getSubFilesPaths(subFiles);
        main(subFilesPath);
      }

      Optional<String> extension = getFileExtension(file.getPath());
      if (!extension.isPresent() || extension.isEmpty() ||
          !extension.get().equals("java")) {
        continue;
      }

      List<MethodInfo> methodsInfo = methodExtractor.extract(file);

      String os = System.getProperty("os.name");
      String prefix = os.trim().contains("Windows") ? "temp\\" : "temp";
      String tempFilePath = prefix + removeExtension(file.getPath());
      System.out.println(tempFilePath);
      String projectRootDir = System.getProperty("user.dir");
      System.out.println(projectRootDir);

      // File tempDir = new File(tempFilePath);
      // if (!tempDir.exists()) {
      // tempDir.mkdirs();
      // }
      //
      // System.setProperty("user.dir", tempFilePath);
      //
      // for (MethodInfo methodInfo : methodsInfo) {
      // try (FileWriter writer = new FileWriter(methodInfo.getName() +
      // ".java")) {
      // writer.write(methodInfo.getBody());
      // } catch (IOException e) {
      // e.printStackTrace();
      // }
      // }
      // System.setProperty("user.dir", projectRootDir);
    }
  }

  private static void serialize(MethodInfo info) {
  }

  private static Optional<String> getFileExtension(String filename) {
    return Optional.ofNullable(filename)
        .filter(f -> f.contains("."))
        .map(f -> f.substring(filename.lastIndexOf(".") + 1));
  }

  private static String removeExtension(String filename) {
    return filename.replaceFirst("[.][^.]+$", "");
  }

  private static String[] getSubFilesPaths(List<File> files) {
    return files.stream().map(file -> file.getPath()).toArray(String[]::new);
  }
}
