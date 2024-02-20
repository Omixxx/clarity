/* (C)2024 */
package it.unimol;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MethodExtractor {
  private List<MethodInfo> methods = new ArrayList<>();

  public List<MethodInfo> extract(File file) throws IOException {

    try (InputStream s = Files.newInputStream(Paths.get(file.getPath()))) {

      CompilationUnit cu = StaticJavaParser.parse(s);
      for (MethodDeclaration method : cu.findAll(MethodDeclaration.class)) {
        this.methods.add(new MethodInfo(
            method.getNameAsString(),
            method.getBody().isPresent() ? method.getBody().get().toString()
                : "",
            method.getRange().get().begin.line,
            method.getRange().get().end.line, file,
            method.getDeclarationAsString(true, true)));
      }
    } catch (IOException e) {
      throw new IOException("Error while reading the file");
    }
    return this.methods;
  }
}
