class Snippet {
   public static boolean interfloorTeleportAllowed(){
       if (Dungeon.level.locked || Dungeon.level instanceof MiningLevel || (Dungeon.hero != null && Dungeon.hero.belongings.getItem(Amulet.class) != null)) {
           return false;
       }
       return true;
   }

}