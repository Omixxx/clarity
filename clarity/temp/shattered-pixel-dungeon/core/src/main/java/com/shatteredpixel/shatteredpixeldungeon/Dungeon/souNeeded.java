class Snippet {
   public static boolean souNeeded(){
       int souLeftThisSet;
       //3 SOU each floor set
       souLeftThisSet = 3 - (LimitedDrops.UPGRADE_SCROLLS.count - (depth / 5) * 3);
       if (souLeftThisSet <= 0)
           return false;
       int floorThisSet = (depth % 5);
       //chance is floors left / scrolls left
       return Random.Int(5 - floorThisSet) < souLeftThisSet;
   }
}