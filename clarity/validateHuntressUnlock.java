class Snippet {
   public static void validateHuntressUnlock(){
       if (Statistics.thrownAttacks >= 10 && !isUnlocked(Badge.UNLOCK_HUNTRESS)) {
           displayBadge(Badge.UNLOCK_HUNTRESS);
       }
   }

}