/* (C)2024 */
package it.unimol.Miner;

final class MethodInfo {

  private String name;
  private String declaration;
  private String body;
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
    this.declaration = declaration;
    this.body = body;
    this.startLine = startLine;
    this.endLine = endLine;
    this.originFileAbsolutePath = orginFileAbsolutePath;
    this.originFileRelativePath = relativePath;
  }

  public String getAbsolutePathOfOriginalFile() {
    return this.originFileAbsolutePath;
  }

  public String getRelativePathOfOriginalFile() {
    return this.originFileRelativePath;
  }

  public String getBody() {
    return body;
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

  public String getDeclaration() {
    return this.declaration;
  }
  
  public Double getReadabilityScore() {
    return readabilityScore;
  }

  public void setReadabilityScore(Double readabilityScore) {
    this.readabilityScore = readabilityScore;
  }

}
