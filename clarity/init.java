class Snippet {
   public static void init(){
       add(Dungeon.hero);
       for (Mob mob : Dungeon.level.mobs) {
           add(mob);
       }
       //mobs need to remember their targets after every actor is added
       for (Mob mob : Dungeon.level.mobs) {
           mob.restoreEnemy();
       }
       for (Blob blob : Dungeon.level.blobs.values()) {
           add(blob);
       }
       current = null;
   }

}