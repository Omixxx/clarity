class Snippet {
   private static void setupPassable(){
       if (passable == null || passable.length != Dungeon.level.length())
           passable = new boolean[Dungeon.level.length()];
       else
           BArray.setFalse(passable);
   }
}