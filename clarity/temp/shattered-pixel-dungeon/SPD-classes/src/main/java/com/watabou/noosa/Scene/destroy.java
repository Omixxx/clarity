class Snippet {
  public void destroy(){
      KeyEvent.removeKeyListener(keyListener);
      super.destroy();
  }
}