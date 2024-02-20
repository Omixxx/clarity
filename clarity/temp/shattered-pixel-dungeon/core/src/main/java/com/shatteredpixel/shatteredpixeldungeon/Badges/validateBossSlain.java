class Snippet {
   public static void validateBossSlain(){
       Badge badge = null;
       switch(Dungeon.depth) {
           case 5:
               badge = Badge.BOSS_SLAIN_1;
               break;
           case 10:
               badge = Badge.BOSS_SLAIN_2;
               break;
           case 15:
               badge = Badge.BOSS_SLAIN_3;
               break;
           case 20:
               badge = Badge.BOSS_SLAIN_4;
               break;
       }
       if (badge != null) {
           local.add(badge);
           displayBadge(badge);
           if (badge == Badge.BOSS_SLAIN_1) {
               badge = firstBossClassBadges.get(Dungeon.hero.heroClass);
               if (badge == null)
                   return;
               local.add(badge);
               unlock(badge);
               boolean allUnlocked = true;
               for (Badge b : firstBossClassBadges.values()) {
                   if (!isUnlocked(b)) {
                       allUnlocked = false;
                       break;
                   }
               }
               if (allUnlocked) {
                   badge = Badge.BOSS_SLAIN_1_ALL_CLASSES;
                   if (!isUnlocked(badge)) {
                       displayBadge(badge);
                   }
               }
           } else if (badge == Badge.BOSS_SLAIN_3) {
               badge = thirdBossSubclassBadges.get(Dungeon.hero.subClass);
               if (badge == null)
                   return;
               local.add(badge);
               unlock(badge);
               boolean allUnlocked = true;
               for (Badge b : thirdBossSubclassBadges.values()) {
                   if (!isUnlocked(b)) {
                       allUnlocked = false;
                       break;
                   }
               }
               if (allUnlocked) {
                   badge = Badge.BOSS_SLAIN_3_ALL_SUBCLASSES;
                   if (!isUnlocked(badge)) {
                       displayBadge(badge);
                   }
               }
           }
           if (Statistics.qualifiedForBossRemainsBadge && Dungeon.hero.belongings.getItem(RemainsItem.class) != null) {
               badge = Badge.BOSS_SLAIN_REMAINS;
               if (!isUnlocked(badge)) {
                   displayBadge(badge);
               }
           }
       }
   }
}