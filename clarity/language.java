class Snippet {
   public static Languages language(){
       String code = getString(KEY_LANG, null);
       if (code == null) {
           return Languages.matchLocale(Locale.getDefault());
       } else {
           return Languages.matchCode(code);
       }
   }

}