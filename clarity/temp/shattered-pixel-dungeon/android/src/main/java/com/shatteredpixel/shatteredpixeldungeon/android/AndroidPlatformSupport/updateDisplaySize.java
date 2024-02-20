class Snippet {
  public void updateDisplaySize(){
      if (SPDSettings.landscape() != null) {
          AndroidLauncher.instance.setRequestedOrientation(SPDSettings.landscape() ? ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE : ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);
      }
      GLSurfaceView view = (GLSurfaceView) ((AndroidGraphics) Gdx.graphics).getView();
      if (view.getMeasuredWidth() == 0 || view.getMeasuredHeight() == 0)
          return;
      Game.dispWidth = view.getMeasuredWidth();
      Game.dispHeight = view.getMeasuredHeight();
      boolean fullscreen = Build.VERSION.SDK_INT < Build.VERSION_CODES.N || !AndroidLauncher.instance.isInMultiWindowMode();
      if (fullscreen && SPDSettings.landscape() != null && (Game.dispWidth >= Game.dispHeight) != SPDSettings.landscape()) {
          int tmp = Game.dispWidth;
          Game.dispWidth = Game.dispHeight;
          Game.dispHeight = tmp;
      }
      float dispRatio = Game.dispWidth / (float) Game.dispHeight;
      float renderWidth = dispRatio > 1 ? PixelScene.MIN_WIDTH_L : PixelScene.MIN_WIDTH_P;
      float renderHeight = dispRatio > 1 ? PixelScene.MIN_HEIGHT_L : PixelScene.MIN_HEIGHT_P;
      //force power saver in this case as all devices must run at at least 2x scale.
      if (Game.dispWidth < renderWidth * 2 || Game.dispHeight < renderHeight * 2)
          SPDSettings.put(SPDSettings.KEY_POWER_SAVER, true);
      if (SPDSettings.powerSaver() && fullscreen) {
          int maxZoom = (int) Math.min(Game.dispWidth / renderWidth, Game.dispHeight / renderHeight);
          renderWidth *= Math.max(2, Math.round(1f + maxZoom * 0.4f));
          renderHeight *= Math.max(2, Math.round(1f + maxZoom * 0.4f));
          if (dispRatio > renderWidth / renderHeight) {
              renderWidth = renderHeight * dispRatio;
          } else {
              renderHeight = renderWidth / dispRatio;
          }
          final int finalW = Math.round(renderWidth);
          final int finalH = Math.round(renderHeight);
          if (finalW != Game.width || finalH != Game.height) {
              AndroidLauncher.instance.runOnUiThread(new Runnable() {
  
                  @Override
                  public void run() {
                      view.getHolder().setFixedSize(finalW, finalH);
                  }
              });
          }
      } else {
          AndroidLauncher.instance.runOnUiThread(new Runnable() {
  
              @Override
              public void run() {
                  view.getHolder().setSizeFromLayout();
              }
          });
      }
  }
}