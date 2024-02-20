class Snippet {
  public void create(){
      density = Gdx.graphics.getDensity();
      if (density == Float.POSITIVE_INFINITY) {
          //assume 100PPI if density can't be found
          density = 100f / 160f;
      }
      dispHeight = Gdx.graphics.getDisplayMode().height;
      dispWidth = Gdx.graphics.getDisplayMode().width;
      inputHandler = new InputHandler(Gdx.input);
      if (ControllerHandler.controllersSupported()) {
          Controllers.addListener(new ControllerHandler());
      }
      //refreshes texture and vertex data stored on the gpu
      versionContextRef = Gdx.graphics.getGLVersion();
      Blending.useDefault();
      TextureCache.reload();
      Vertexbuffer.reload();
  }
}