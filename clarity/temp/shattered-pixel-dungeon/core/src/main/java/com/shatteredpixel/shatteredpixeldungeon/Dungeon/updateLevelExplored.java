class Snippet {
   public static void updateLevelExplored(){
       if (branch == 0 && level instanceof RegularLevel && !Dungeon.bossLevel()) {
           Statistics.floorsExplored.put(depth, level.isLevelExplored(depth));
       }
   }
}