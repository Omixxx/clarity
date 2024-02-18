class Snippet {
     public static void saveAll() throws IOException{
         if (hero != null && (hero.isAlive() || WndResurrect.instance != null)) {
             Actor.fixTime();
             updateLevelExplored();
             saveGame(GamesInProgress.curSlot);
             saveLevel(GamesInProgress.curSlot);
             GamesInProgress.set(GamesInProgress.curSlot);
         }
     }

}