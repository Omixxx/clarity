class Snippet {
  public void destroy(){
      if (scene != null) {
          scene.destroy();
          scene = null;
      }
      sceneClass = null;
      Music.INSTANCE.stop();
      Sample.INSTANCE.reset();
  }
}