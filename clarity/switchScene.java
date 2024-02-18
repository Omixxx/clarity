class Snippet {
  protected void switchScene(){
      Camera.reset();
      if (scene != null) {
          scene.destroy();
      }
      //clear any leftover vertex buffers
      Vertexbuffer.clear();
      scene = requestedScene;
      if (onChange != null)
          onChange.beforeCreate();
      scene.create();
      if (onChange != null)
          onChange.afterCreate();
      onChange = null;
      Game.elapsed = 0f;
      Game.timeScale = 1f;
      Game.timeTotal = 0f;
  }

}