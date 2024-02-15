package it.unimol;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.BlockStmt;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class MethodExtractor {
  private static ArrayList<BlockStmt> methods = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    if (args.length != 1) {
      System.out.println("Usage: java Main <file>");
      System.exit(1);
    }

    if (args[0].isBlank() || !Files.exists(Paths.get(args[0]))) {
      System.out.println("File not found");
      System.exit(1);
    }

    CompilationUnit cu = StaticJavaParser.parse(Files.newInputStream(Paths.get(args[0])));
    for (MethodDeclaration method : cu.findAll(MethodDeclaration.class)) {
      method.getBody().ifPresent(body -> {
        methods.add(body);
      });
    }

    for (BlockStmt method : methods) {
      System.out.println(method);
    }
  }
}
