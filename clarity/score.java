class Snippet {
   private int score(boolean win){
       return (Statistics.goldCollected + Dungeon.hero.lvl * (win ? 26 : Dungeon.depth) * 100) * (win ? 2 : 1);
   }

}