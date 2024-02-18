class Snippet {
   public static String toolbarMode(){
       return getString(KEY_BARMODE, PixelScene.landscape() ? "GROUP" : "SPLIT");
   }

}