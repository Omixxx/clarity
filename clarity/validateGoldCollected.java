class Snippet {
   public static void validateGoldCollected(){
       Badge badge = null;
       if (!local.contains(Badge.GOLD_COLLECTED_1) && Statistics.goldCollected >= 250) {
           if (badge != null)
               unlock(badge);
           badge = Badge.GOLD_COLLECTED_1;
           local.add(badge);
       }
       if (!local.contains(Badge.GOLD_COLLECTED_2) && Statistics.goldCollected >= 1000) {
           if (badge != null)
               unlock(badge);
           badge = Badge.GOLD_COLLECTED_2;
           local.add(badge);
       }
       if (!local.contains(Badge.GOLD_COLLECTED_3) && Statistics.goldCollected >= 2500) {
           if (badge != null)
               unlock(badge);
           badge = Badge.GOLD_COLLECTED_3;
           local.add(badge);
       }
       if (!local.contains(Badge.GOLD_COLLECTED_4) && Statistics.goldCollected >= 7500) {
           if (badge != null)
               unlock(badge);
           badge = Badge.GOLD_COLLECTED_4;
           local.add(badge);
       }
       if (!local.contains(Badge.GOLD_COLLECTED_5) && Statistics.goldCollected >= 15_000) {
           if (badge != null)
               unlock(badge);
           badge = Badge.GOLD_COLLECTED_5;
           local.add(badge);
       }
       displayBadge(badge);
   }

}