class Snippet {
  public void destroy(){
      PointerEvent.removePointerListener(this);
      super.destroy();
  }
}