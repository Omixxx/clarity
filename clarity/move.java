class Snippet {
     public void move(int step, boolean travelling){
         if (travelling && Dungeon.level.adjacent(step, pos) && buff(Vertigo.class) != null) {
             sprite.interruptMotion();
             int newPos = pos + PathFinder.NEIGHBOURS8[Random.Int(8)];
             if (!(Dungeon.level.passable[newPos] || Dungeon.level.avoid[newPos]) || (properties().contains(Property.LARGE) && !Dungeon.level.openSpace[newPos]) || Actor.findChar(newPos) != null)
                 return;
             else {
                 sprite.move(pos, newPos);
                 step = newPos;
             }
         }
         if (Dungeon.level.map[pos] == Terrain.OPEN_DOOR) {
             Door.leave(pos);
         }
         pos = step;
         if (this != Dungeon.hero) {
             sprite.visible = Dungeon.level.heroFOV[pos];
         }
         Dungeon.level.occupyCell(this);
     }

}