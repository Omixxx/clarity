package it.unimol;

import java.io.File;

final class MethodInfo {

  private String name;
  private String body;
  private Integer startLine;
  private Integer endLine;
  private File originFile;

  public MethodInfo() {
  }

  public MethodInfo(String name, String body, Integer startLine,
      Integer endLine, File originFile) {
    this.name = name;
    this.body = body;
    this.startLine = startLine;
    this.endLine = endLine;
    this.originFile = originFile;
  }

  public File getOriginFile() {
    return this.originFile;
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
