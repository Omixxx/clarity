class Snippet {
   public static boolean controllerPointerActive(){
       return controllerPointerActive && !Cursor.isCursorCaptured();
   }
}