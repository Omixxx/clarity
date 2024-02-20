class Snippet {
   public static int scalingDepth(){
       if (Dungeon.hero != null && Dungeon.hero.buff(AscensionChallenge.class) != null) {
           return 26;
       } else {
           return depth;
       }
   }
}