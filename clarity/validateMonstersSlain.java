class Snippet {
   public static void validateMonstersSlain(){
       Badge badge = null;
       if (!local.contains(Badge.MONSTERS_SLAIN_1) && Statistics.enemiesSlain >= 10) {
           badge = Badge.MONSTERS_SLAIN_1;
           local.add(badge);
       }
       if (!local.contains(Badge.MONSTERS_SLAIN_2) && Statistics.enemiesSlain >= 50) {
           if (badge != null)
               unlock(badge);
           badge = Badge.MONSTERS_SLAIN_2;
           local.add(badge);
       }
       if (!local.contains(Badge.MONSTERS_SLAIN_3) && Statistics.enemiesSlain >= 100) {
           if (badge != null)
               unlock(badge);
           badge = Badge.MONSTERS_SLAIN_3;
           local.add(badge);
       }
       if (!local.contains(Badge.MONSTERS_SLAIN_4) && Statistics.enemiesSlain >= 250) {
           if (badge != null)
               unlock(badge);
           badge = Badge.MONSTERS_SLAIN_4;
           local.add(badge);
       }
       if (!local.contains(Badge.MONSTERS_SLAIN_5) && Statistics.enemiesSlain >= 500) {
           if (badge != null)
               unlock(badge);
           badge = Badge.MONSTERS_SLAIN_5;
           local.add(badge);
       }
       displayBadge(badge);
   }

}