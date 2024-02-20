class Snippet {
   public static void validateHappyEnd(){
       displayBadge(Badge.HAPPY_END);
       if (local.contains(Badge.HAPPY_END_REMAINS)) {
           displayBadge(Badge.HAPPY_END_REMAINS);
       }
   }
}