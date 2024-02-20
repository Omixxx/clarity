class Snippet {
   public static void validateRogueUnlock(){
       if (Statistics.sneakAttacks >= 10 && !isUnlocked(Badge.UNLOCK_ROGUE)) {
           displayBadge(Badge.UNLOCK_ROGUE);
       }
   }
}