class Snippet {
   private static void validateDeathFromAll(){
       if (isUnlocked(Badge.DEATH_FROM_FIRE) && isUnlocked(Badge.DEATH_FROM_POISON) && isUnlocked(Badge.DEATH_FROM_GAS) && isUnlocked(Badge.DEATH_FROM_HUNGER) && isUnlocked(Badge.DEATH_FROM_FALLING) && isUnlocked(Badge.DEATH_FROM_ENEMY_MAGIC) && isUnlocked(Badge.DEATH_FROM_FRIENDLY_MAGIC) && isUnlocked(Badge.DEATH_FROM_SACRIFICE) && isUnlocked(Badge.DEATH_FROM_GRIM_TRAP)) {
           Badge badge = Badge.DEATH_FROM_ALL;
           if (!isUnlocked(badge)) {
               displayBadge(badge);
           }
       }
   }

}