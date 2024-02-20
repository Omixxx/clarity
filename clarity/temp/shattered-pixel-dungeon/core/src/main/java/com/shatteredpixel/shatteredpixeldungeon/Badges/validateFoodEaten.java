class Snippet {
   public static void validateFoodEaten(){
       Badge badge = null;
       if (!local.contains(Badge.FOOD_EATEN_1) && Statistics.foodEaten >= 10) {
           badge = Badge.FOOD_EATEN_1;
           local.add(badge);
       }
       if (!local.contains(Badge.FOOD_EATEN_2) && Statistics.foodEaten >= 20) {
           if (badge != null)
               unlock(badge);
           badge = Badge.FOOD_EATEN_2;
           local.add(badge);
       }
       if (!local.contains(Badge.FOOD_EATEN_3) && Statistics.foodEaten >= 30) {
           if (badge != null)
               unlock(badge);
           badge = Badge.FOOD_EATEN_3;
           local.add(badge);
       }
       if (!local.contains(Badge.FOOD_EATEN_4) && Statistics.foodEaten >= 40) {
           if (badge != null)
               unlock(badge);
           badge = Badge.FOOD_EATEN_4;
           local.add(badge);
       }
       if (!local.contains(Badge.FOOD_EATEN_5) && Statistics.foodEaten >= 50) {
           if (badge != null)
               unlock(badge);
           badge = Badge.FOOD_EATEN_5;
           local.add(badge);
       }
       displayBadge(badge);
   }
}