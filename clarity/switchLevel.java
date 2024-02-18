class Snippet {
       public static void switchLevel(final Level level, int pos){
           //Position of -2 specifically means trying to place the hero the exit
           if (pos == -2) {
               LevelTransition t = level.getTransition(LevelTransition.Type.REGULAR_EXIT);
               if (t != null)
                   pos = t.cell();
           }
           //Place hero at the entrance if they are out of the map (often used for pox = -1)
           // or if they are in solid terrain (except in the mining level, where that happens normally)
           if (pos < 0 || pos >= level.length() || (!(level instanceof MiningLevel) && !level.passable[pos] && !level.avoid[pos])) {
               pos = level.getTransition(null).cell();
           }
           PathFinder.setMapSize(level.width(), level.height());
           Dungeon.level = level;
           hero.pos = pos;
           if (hero.buff(AscensionChallenge.class) != null) {
               hero.buff(AscensionChallenge.class).onLevelSwitch();
           }
           Mob.restoreAllies(level, pos);
           Actor.init();
           level.addRespawner();
           for (Mob m : level.mobs) {
               if (m.pos == hero.pos && !Char.hasProp(m, Char.Property.IMMOVABLE)) {
                   //displace mob
                   for (int i : PathFinder.NEIGHBOURS8) {
                       if (Actor.findChar(m.pos + i) == null && level.passable[m.pos + i]) {
                           m.pos += i;
                           break;
                       }
                   }
               }
           }
           Light light = hero.buff(Light.class);
           hero.viewDistance = light == null ? level.viewDistance : Math.max(Light.DISTANCE, level.viewDistance);
           hero.curAction = hero.lastAction = null;
           observe();
           try {
               saveAll();
           } catch (IOException e) {
               ShatteredPixelDungeon.reportException(e);
               /*This only catches IO errors. Yes, this means things can go wrong, and they can go wrong catastrophically.
       			But when they do the user will get a nice 'report this issue' dialogue, and I can fix the bug.*/
           }
       }

}