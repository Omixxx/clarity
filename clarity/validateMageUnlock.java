class Snippet {
   public static void validateMageUnlock(){
       if (Statistics.upgradesUsed >= 1 && !isUnlocked(Badge.UNLOCK_MAGE)) {
           displayBadge(Badge.UNLOCK_MAGE);
       }
   }

}