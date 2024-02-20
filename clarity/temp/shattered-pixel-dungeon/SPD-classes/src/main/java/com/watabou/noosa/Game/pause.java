class Snippet {
  public void pause(){
      PointerEvent.clearPointerEvents();
      if (scene != null) {
          scene.onPause();
      }
      Script.reset();
  }
}