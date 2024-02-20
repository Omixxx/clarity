class Snippet {
   public static void validateVictory(){
       Badge badge = Badge.VICTORY;
       local.add(badge);
       displayBadge(badge);
       badge = victoryClassBadges.get(Dungeon.hero.heroClass);
       if (badge == null)
           return;
       local.add(badge);
       unlock(badge);
       boolean allUnlocked = true;
       for (Badge b : victoryClassBadges.values()) {
           if (!isUnlocked(b)) {
               allUnlocked = false;
               break;
           }
       }
       if (allUnlocked) {
           badge = Badge.VICTORY_ALL_CLASSES;
           displayBadge(badge);
       }
   }
}