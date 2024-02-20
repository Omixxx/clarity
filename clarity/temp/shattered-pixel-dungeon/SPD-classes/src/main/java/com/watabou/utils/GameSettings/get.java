class Snippet {
   private static Preferences get(){
       if (prefs == null) {
           prefs = Gdx.app.getPreferences(DEFAULT_PREFS_FILE);
       }
       return prefs;
   }
}