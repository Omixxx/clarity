class Snippet {
   public static void resetLevel(){
       Actor.clear();
       level.reset();
       switchLevel(level, level.entrance());
   }
}