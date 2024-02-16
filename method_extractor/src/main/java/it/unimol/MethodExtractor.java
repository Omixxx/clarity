package it.unimol;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MethodExtractor {
  private List<MethodInfo> methods = new ArrayList<>();

  public List<MethodInfo> extract(File file) throws IOException {

    if (file.isDirectory() || !file.exists()) {
      System.out.println("File not found");
      System.exit(1);
    }

    CompilationUnit cu = StaticJavaParser.parse(Files.newInputStream(Paths.get(file.getPath())));
    for (MethodDeclaration method : cu.findAll(MethodDeclaration.class)) {
      this.methods.add(new MethodInfo(method.getNameAsString(),
          method.getBody().toString(),
          method.getRange().get().begin.line,
          method.getRange().get().end.line, file));
    }
    return this.methods;
  }
}
