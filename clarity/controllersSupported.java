class Snippet {
   public static boolean controllersSupported(){
       if (DeviceCompat.isAndroid() && Gdx.app.getVersion() < 16) {
           return false;
       } else if (failedInit) {
           return false;
       } else if (initialized) {
           return true;
       } else {
           try {
               //we do this to call Controllers.initialize(), which can fail in certain cases
               // e.g. missing natives on very old 32-bit desktop platforms
               Controllers.getCurrent();
               initialized = true;
               return true;
           } catch (Exception e) {
               failedInit = true;
               return false;
           }
       }
   }

}