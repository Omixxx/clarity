class Snippet {
  protected void step(){
      if (requestedReset) {
          requestedReset = false;
          requestedScene = Reflection.newInstance(sceneClass);
          if (requestedScene != null) {
              switchScene();
          }
      }
      update();
  }

}