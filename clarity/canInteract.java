class Snippet {
   public boolean canInteract(Char c){
       if (Dungeon.level.adjacent(pos, c.pos)) {
           return true;
       } else if (c instanceof Hero && alignment == Alignment.ALLY && !hasProp(this, Property.IMMOVABLE) && Dungeon.level.distance(pos, c.pos) <= 2 * Dungeon.hero.pointsInTalent(Talent.ALLY_WARP)) {
           return true;
       } else {
           return false;
       }
   }

}