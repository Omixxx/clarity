class Snippet {
   public static void validateLevelReached(){
       Badge badge = null;
       if (!local.contains(Badge.LEVEL_REACHED_1) && Dungeon.hero.lvl >= 6) {
           badge = Badge.LEVEL_REACHED_1;
           local.add(badge);
       }
       if (!local.contains(Badge.LEVEL_REACHED_2) && Dungeon.hero.lvl >= 12) {
           if (badge != null)
               unlock(badge);
           badge = Badge.LEVEL_REACHED_2;
           local.add(badge);
       }
       if (!local.contains(Badge.LEVEL_REACHED_3) && Dungeon.hero.lvl >= 18) {
           if (badge != null)
               unlock(badge);
           badge = Badge.LEVEL_REACHED_3;
           local.add(badge);
       }
       if (!local.contains(Badge.LEVEL_REACHED_4) && Dungeon.hero.lvl >= 24) {
           if (badge != null)
               unlock(badge);
           badge = Badge.LEVEL_REACHED_4;
           local.add(badge);
       }
       if (!local.contains(Badge.LEVEL_REACHED_5) && Dungeon.hero.lvl >= 30) {
           if (badge != null)
               unlock(badge);
           badge = Badge.LEVEL_REACHED_5;
           local.add(badge);
       }
       displayBadge(badge);
   }

}