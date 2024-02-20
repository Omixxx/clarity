class Snippet {
   public static boolean vibrationSupported(){
       return isControllerConnected() && Controllers.getCurrent().canVibrate();
   }
}