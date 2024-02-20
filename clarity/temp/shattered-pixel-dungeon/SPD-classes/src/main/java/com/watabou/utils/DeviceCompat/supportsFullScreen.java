class Snippet {
   public static boolean supportsFullScreen(){
       switch(Gdx.app.getType()) {
           case Android:
               //Android 4.4+ supports hiding UI via immersive mode
               return Gdx.app.getVersion() >= 19;
           case iOS:
               //iOS supports hiding UI via drawing into the gesture safe area
               return Gdx.graphics.getSafeInsetBottom() != 0;
           default:
               //TODO implement functionality for other platforms here
               return true;
       }
   }
}