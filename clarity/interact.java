class Snippet {
   public boolean interact(Char c){
       //don't allow char to swap onto hazard unless they're flying
       //you can swap onto a hazard though, as you're not the one instigating the swap
       if (!Dungeon.level.passable[pos] && !c.flying) {
           return true;
       }
       //can't swap into a space without room
       if (properties().contains(Property.LARGE) && !Dungeon.level.openSpace[c.pos] || c.properties().contains(Property.LARGE) && !Dungeon.level.openSpace[pos]) {
           return true;
       }
       //we do a little raw position shuffling here so that the characters are never
       // on the same cell when logic such as occupyCell() is triggered
       int oldPos = pos;
       int newPos = c.pos;
       //can't swap or ally warp if either char is immovable
       if (hasProp(this, Property.IMMOVABLE) || hasProp(c, Property.IMMOVABLE)) {
           return true;
       }
       //warp instantly with allies in this case
       if (c == Dungeon.hero && Dungeon.hero.hasTalent(Talent.ALLY_WARP)) {
           PathFinder.buildDistanceMap(c.pos, BArray.or(Dungeon.level.passable, Dungeon.level.avoid, null));
           if (PathFinder.distance[pos] == Integer.MAX_VALUE) {
               return true;
           }
           pos = newPos;
           c.pos = oldPos;
           ScrollOfTeleportation.appear(this, newPos);
           ScrollOfTeleportation.appear(c, oldPos);
           Dungeon.observe();
           GameScene.updateFog();
           return true;
       }
       //can't swap places if one char has restricted movement
       if (rooted || c.rooted || buff(Vertigo.class) != null || c.buff(Vertigo.class) != null) {
           return true;
       }
       c.pos = oldPos;
       moveSprite(oldPos, newPos);
       move(newPos);
       c.pos = newPos;
       c.sprite.move(newPos, oldPos);
       c.move(oldPos);
       c.spend(1 / c.speed());
       if (c == Dungeon.hero) {
           if (Dungeon.hero.subClass == HeroSubClass.FREERUNNER) {
               Buff.affect(Dungeon.hero, Momentum.class).gainStack();
           }
           Dungeon.hero.busy();
       }
       return true;
   }

}