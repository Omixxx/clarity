class Snippet {
  public void pasteFromClipboard(){
      String contents = Gdx.app.getClipboard().getContents();
      if (contents == null)
          return;
      if (!textField.getSelection().isEmpty()) {
          //just use cut, but override clipboard
          textField.cut();
          Gdx.app.getClipboard().setContents(contents);
      }
      String existing = textField.getText();
      int cursorIdx = textField.getCursorPosition();
      textField.setText(existing.substring(0, cursorIdx) + contents + existing.substring(cursorIdx));
      textField.setCursorPosition(cursorIdx + contents.length());
  }

}