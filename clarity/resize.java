class Snippet {
     public void resize(int width, int height){
         if (width == 0 || height == 0) {
             return;
         }
         //If the EGL context was destroyed, we need to refresh some data stored on the GPU.
         // This checks that by seeing if GLVersion has a new object reference
         if (versionContextRef != Gdx.graphics.getGLVersion()) {
             versionContextRef = Gdx.graphics.getGLVersion();
             Blending.useDefault();
             TextureCache.reload();
             Vertexbuffer.reload();
         }
         height -= bottomInset;
         if (height != Game.height || width != Game.width) {
             Game.width = width;
             Game.height = height;
             //TODO might be better to put this in platform support
             if (Gdx.app.getType() != Application.ApplicationType.Android) {
                 Game.dispWidth = Game.width;
                 Game.dispHeight = Game.height;
             }
             resetScene();
         }
     }

}