class Snippet {
   public static boolean isControllerConnected(){
       return controllersSupported() && Controllers.getCurrent() != null;
   }

}