class Snippet {
   public static Boolean landscape(){
       if (contains(KEY_LANDSCAPE)) {
           return getBoolean(KEY_LANDSCAPE, false);
       } else {
           return null;
       }
   }

}