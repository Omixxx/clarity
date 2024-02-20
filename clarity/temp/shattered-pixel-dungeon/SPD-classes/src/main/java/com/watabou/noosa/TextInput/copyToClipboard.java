class Snippet {
  public void copyToClipboard(){
      if (textField.getSelection().isEmpty()) {
          textField.selectAll();
      }
      textField.copy();
  }
}