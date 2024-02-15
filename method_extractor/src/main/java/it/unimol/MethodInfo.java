package it.unimol;

final class MethodInfo {

  private String name;
  private String body;
  private Integer startLine;
  private Integer endLine;

  public MethodInfo(String name, String body, Integer startLine,
      Integer endLine) {
    this.name = name;
    this.body = body;
    this.startLine = startLine;
    this.endLine = endLine;
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
}
