/* (C)2024 */
package it.unimol.miner;

final class MethodInfo implements Comparable<MethodInfo> {

  private String name;
  private String method;
  private Integer startLine;
  private Integer endLine;
  private String originFileAbsolutePath;
  private String originFileRelativePath;
  private Double readabilityScore;

  public MethodInfo() {
  }

  public MethodInfo(String name, String body, Integer startLine,
      Integer endLine, String orginFileAbsolutePath,
      String relativePath, String declaration) {
    this.name = name;
    this.startLine = startLine;
    this.endLine = endLine;
    this.originFileAbsolutePath = orginFileAbsolutePath;
    this.originFileRelativePath = relativePath;
    this.method = mergeBodyAndDeclaration(body, declaration);
  }

  public String getAbsolutePathOfOriginalFile() {
    return this.originFileAbsolutePath;
  }

  public String getRelativePathOfOriginalFile() {
    return this.originFileRelativePath;
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

  private String mergeBodyAndDeclaration(String body, String declaration) {
    String nonFormattedMethod = declaration + body;
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
