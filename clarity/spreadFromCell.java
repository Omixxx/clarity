class Snippet {
     private void spreadFromCell(int cell, int power){
         if (cur[cell] == 0) {
             area.union(cell % Dungeon.level.width(), cell / Dungeon.level.width());
         }
         cur[cell] = Math.max(cur[cell], power);
         for (int c : PathFinder.NEIGHBOURS4) {
             if (water[cell + c] && cur[cell + c] < power) {
                 spreadFromCell(cell + c, power);
             }
         }
     }

}