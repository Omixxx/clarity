class Snippet {
     protected boolean moveSprite(int from, int to){
         if (sprite.isVisible() && sprite.parent != null && (Dungeon.level.heroFOV[from] || Dungeon.level.heroFOV[to])) {
             sprite.move(from, to);
             return true;
         } else {
             sprite.turnTo(from, to);
             sprite.place(to);
             return true;
         }
     }

}