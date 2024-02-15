package it.unimol;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class Main {

  private static final Logger LOGGER = Logger.getLogger(Process.class.getName());
  private static final MethodExtractor methodExtractor = new MethodExtractor();

  public static void main(String[] args) throws IOException {
    for (String filePath : args) {
      // LOGGER.info("Processing file: " + filePath);
      File file = new File(filePath);

      if (file.isDirectory()) {
        List<File> subFiles = Arrays.asList(file.listFiles());
        String[] subFilesPath = getSubFilesPaths(subFiles);
        main(subFilesPath);
      }

      Optional<String> extension = getFileExtension(filePath);
      if (extension.isPresent() && !extension.isEmpty() &&
          extension.get().equals("java")) {
        List<MethodInfo> infos = methodExtractor.extract(file);
        infos.forEach(info -> {
          System.out.println("name" + info.getName());
        });
      }
    }

    // TODO: creazione dei file temporanei

    // List<MethodInfo> methods = methodExtractor.extract(filePath);

    // String tempFilePath = prefix + filePath.split("\\.")[0];
    // String fileType = filePath.split("\\.")[1];
    // String rootDir = System.getProperty("user.dir");
    //
    // File tempDir = new File(tempFilePath);
    // if (!tempDir.exists()) {
    // tempDir.mkdirs();
    // }
    //
    // System.setProperty("user.dir", tempFilePath);
    //
    // for (MethodInfo method : methods) {
    // try (FileWriter writer = new FileWriter(method.getName() + "." +
    // fileType)) {
    // writer.write(method.getBody());
    // } catch (IOException e) {
    // e.printStackTrace();
    // }
    // }
    //
    // System.setProperty("user.dir", rootDir);
  }

  private static Optional<String> getFileExtension(String filename) {
    return Optional.ofNullable(filename)
        .filter(f -> f.contains("."))
        .map(f -> f.substring(filename.lastIndexOf(".") + 1));
  }

  private static String[] getSubFilesPaths(List<File> files) {
    return files.stream().map(file -> file.getPath()).toArray(String[]::new);
  }
}
