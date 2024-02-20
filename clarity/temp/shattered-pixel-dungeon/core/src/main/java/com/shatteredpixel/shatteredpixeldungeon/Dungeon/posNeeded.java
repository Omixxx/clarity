class Snippet {
   public static boolean posNeeded(){
       //2 POS each floor set
       int posLeftThisSet = 2 - (LimitedDrops.STRENGTH_POTIONS.count - (depth / 5) * 2);
       if (posLeftThisSet <= 0)
           return false;
       int floorThisSet = (depth % 5);
       //pos drops every two floors, (numbers 1-2, and 3-4) with a 50% chance for the earlier one each time.
       int targetPOSLeft = 2 - floorThisSet / 2;
       if (floorThisSet % 2 == 1 && Random.Int(2) == 0)
           targetPOSLeft--;
       if (targetPOSLeft < posLeftThisSet)
           return true;
       else
           return false;
   }
}