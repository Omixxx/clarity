class Snippet {
   private static boolean lootAtCurLevel(){
       if (branch == Dungeon.branch) {
           if (branch == 0) {
               //always match depth exactly for main path
               return depth == Dungeon.depth;
           } else if (branch == 1) {
               //just match the region for quest sub-floors
               return depth / 5 == Dungeon.depth / 5;
           }
       }
       return false;
   }
}