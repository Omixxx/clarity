class Snippet {
   public static boolean systemFont(){
       return getBoolean(KEY_SYSTEMFONT, (language() == Languages.KOREAN || language() == Languages.CHINESE || language() == Languages.JAPANESE));
   }

}