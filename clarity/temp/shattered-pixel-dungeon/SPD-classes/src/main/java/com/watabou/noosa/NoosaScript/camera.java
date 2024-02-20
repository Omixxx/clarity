class Snippet {
   public void camera(Camera camera){
       if (camera == null) {
           camera = Camera.main;
       }
       if (camera != lastCamera && camera.matrix != null) {
           lastCamera = camera;
           uCamera.valueM4(camera.matrix);
           if (!camera.fullScreen) {
               Gdx.gl20.glEnable(Gdx.gl20.GL_SCISSOR_TEST);
               //This fixes pixel scaling issues on some hidpi displays (mainly on macOS)
               // because for some reason all other openGL operations work on virtual pixels
               // but glScissor operations work on real pixels
               float xScale = (Gdx.graphics.getBackBufferWidth() / (float) Game.width);
               float yScale = ((Gdx.graphics.getBackBufferHeight() - Game.bottomInset) / (float) Game.height);
               Gdx.gl20.glScissor(Math.round(camera.x * xScale), Math.round((Game.height - camera.screenHeight - camera.y) * yScale) + Game.bottomInset, Math.round(camera.screenWidth * xScale), Math.round(camera.screenHeight * yScale));
           } else {
               Gdx.gl20.glDisable(Gdx.gl20.GL_SCISSOR_TEST);
           }
       }
   }
}