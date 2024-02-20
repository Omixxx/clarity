class Snippet {
  protected void switchScene(){
      super.switchScene();
      if (scene instanceof PixelScene) {
          ((PixelScene) scene).restoreWindows();
      }
  }
}