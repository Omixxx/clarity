class Snippet {
   public static void validateStrengthAttained(){
       Badge badge = null;
       if (!local.contains(Badge.STRENGTH_ATTAINED_1) && Dungeon.hero.STR >= 12) {
           badge = Badge.STRENGTH_ATTAINED_1;
           local.add(badge);
       }
       if (!local.contains(Badge.STRENGTH_ATTAINED_2) && Dungeon.hero.STR >= 14) {
           if (badge != null)
               unlock(badge);
           badge = Badge.STRENGTH_ATTAINED_2;
           local.add(badge);
       }
       if (!local.contains(Badge.STRENGTH_ATTAINED_3) && Dungeon.hero.STR >= 16) {
           if (badge != null)
               unlock(badge);
           badge = Badge.STRENGTH_ATTAINED_3;
           local.add(badge);
       }
       if (!local.contains(Badge.STRENGTH_ATTAINED_4) && Dungeon.hero.STR >= 18) {
           if (badge != null)
               unlock(badge);
           badge = Badge.STRENGTH_ATTAINED_4;
           local.add(badge);
       }
       if (!local.contains(Badge.STRENGTH_ATTAINED_5) && Dungeon.hero.STR >= 20) {
           if (badge != null)
               unlock(badge);
           badge = Badge.STRENGTH_ATTAINED_5;
           local.add(badge);
       }
       displayBadge(badge);
   }

}