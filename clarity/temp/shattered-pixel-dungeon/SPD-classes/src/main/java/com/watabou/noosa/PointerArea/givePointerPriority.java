class Snippet {
  public void givePointerPriority(){
      PointerEvent.removePointerListener(this);
      PointerEvent.addPointerListener(this);
  }
}