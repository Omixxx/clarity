class Snippet {
  public void render(){
      //prevents weird rare cases where the app is running twice
      if (instance != this) {
          finish();
          return;
      }
      if (justResumed) {
          PointerEvent.clearPointerEvents();
          justResumed = false;
          if (DeviceCompat.isAndroid())
              return;
      }
      NoosaScript.get().resetCamera();
      NoosaScriptNoLighting.get().resetCamera();
      Gdx.gl.glDisable(Gdx.gl.GL_SCISSOR_TEST);
      Gdx.gl.glClear(Gdx.gl.GL_COLOR_BUFFER_BIT);
      draw();
      Gdx.gl.glDisable(Gdx.gl.GL_SCISSOR_TEST);
      step();
  }
}