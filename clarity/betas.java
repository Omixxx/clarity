class Snippet {
   public static boolean betas(){
       return getBoolean(KEY_BETAS, Game.version.contains("BETA") || Game.version.contains("RC"));
   }

}