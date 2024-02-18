class Snippet {
   public static int interfaceSize(){
       int size = getInt(KEY_UI_SIZE, DeviceCompat.isDesktop() ? 2 : 0);
       if (size > 0) {
           //force mobile UI if there is not enough space for full UI
           float wMin = Game.width / PixelScene.MIN_WIDTH_FULL;
           float hMin = Game.height / PixelScene.MIN_HEIGHT_FULL;
           if (Math.min(wMin, hMin) < 2 * Game.density) {
               size = 0;
           }
       }
       return size;
   }

}