class Snippet {
   public static boolean asNeeded(){
       //1 AS each floor set
       int asLeftThisSet = 1 - (LimitedDrops.ARCANE_STYLI.count - (depth / 5));
       if (asLeftThisSet <= 0)
           return false;
       int floorThisSet = (depth % 5);
       //chance is floors left / scrolls left
       return Random.Int(5 - floorThisSet) < asLeftThisSet;
   }

}