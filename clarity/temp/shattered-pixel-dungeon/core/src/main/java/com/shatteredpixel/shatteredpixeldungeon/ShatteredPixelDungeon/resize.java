class Snippet {
     public void resize(int width, int height){
         if (width == 0 || height == 0) {
             return;
         }
         if (scene instanceof PixelScene && (height != Game.height || width != Game.width)) {
             PixelScene.noFade = true;
             ((PixelScene) scene).saveWindows();
         }
         super.resize(width, height);
         updateDisplaySize();
     }
}