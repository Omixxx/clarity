/* (C)2024 */
package it.unimol.miner;

import java.util.List;

final class MethodInfo implements Comparable<MethodInfo> {

  private String name;
  private String method;
  private Integer startLine;
  private Integer endLine;
  private String classPath;
  private Double readabilityScore;
  private ReadabilityLabel label;

  public MethodInfo() {
  }

  public MethodInfo(String name, String body, List<String> annotations,
      Integer startLine, Integer endLine, String declaration,
      String classPath) {
    this.name = name;
    this.startLine = startLine;
    this.endLine = endLine;
    this.classPath = classPath;
    this.method = mergeAnnotationsBodyAndDeclaration(body, declaration, annotations);
    this.label = ReadabilityLabel.NONE;
  }

  public void setReadabilityLabel(ReadabilityLabel label) {
    this.label = label;
  }

  public ReadabilityLabel getReadabilityLabel() {
    return this.label;
  }

  public String getClassPath() {
    return classPath;
  }

  public Integer getStartLine() {
    return startLine;
  }

  public Integer getEndLine() {
    return endLine;
  }

  public String getName() {
    return this.name;
  }

  public String getMethod() {
    return this.method;
  }

  public Double getReadabilityScore() {
    return readabilityScore;
  }

  public void setReadabilityScore(Double readabilityScore) {
    this.readabilityScore = readabilityScore;
  }

  @Override
  public int compareTo(MethodInfo m) {
    return this.getReadabilityScore().compareTo(m.getReadabilityScore());
  }

  private String mergeAnnotationsBodyAndDeclaration(String body,
      String declaration,
      List<String> annotations) {
    String annotationsString = annotations.stream().reduce("", (a, b) -> a + b + "\n");
    String nonFormattedMethod = annotationsString + declaration + body;
    assert (!nonFormattedMethod.isEmpty() && nonFormattedMethod.contains("\n"));

    String spaces = nonFormattedMethod.split("\n")[0].replaceAll("[^ ]", "");
    StringBuilder method = new StringBuilder("");
    for (String str : nonFormattedMethod.split("\n")) {
      method.append(spaces + str + "\n");
    }
    method.deleteCharAt(method.length() - 1);
    return method.toString();
  }
}
