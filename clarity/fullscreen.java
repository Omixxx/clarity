class Snippet {
   public static boolean fullscreen(){
       return getBoolean(KEY_FULLSCREEN, DeviceCompat.isDesktop());
   }

}