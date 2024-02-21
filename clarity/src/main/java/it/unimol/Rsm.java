package it.unimol;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;

public class Rsm {
  private final String RSM_PATH = System.getProperty("user.dir") + "/lib/rsm.jar";

  public double analyze(Path path) {

    String directoryPath = path.toAbsolutePath().toString();
    ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", RSM_PATH, directoryPath);
    processBuilder.directory(new File(System.getProperty("user.dir") + "/lib"));
    StringBuilder output = new StringBuilder();

    try {
      Process process = processBuilder.start();
      BufferedReader is = new BufferedReader(new InputStreamReader(process.getInputStream()));
      String line;
      while ((line = is.readLine()) != null) {
        output.append(line);
      }
      process.waitFor();
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
    return extractScore(output.toString());
  }

  private double extractScore(String output) {
    String[] parts = output.split("\\s+");
    String lastValue = parts[parts.length - 1];
    return Double.parseDouble(lastValue);
  }
}
