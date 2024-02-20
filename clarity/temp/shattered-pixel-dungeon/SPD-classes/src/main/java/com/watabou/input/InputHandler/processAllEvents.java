class Snippet {
  public void processAllEvents(){
      PointerEvent.processPointerEvents();
      KeyEvent.processKeyEvents();
      ScrollEvent.processScrollEvents();
  }
}