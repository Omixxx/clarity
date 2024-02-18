class Snippet {
   public static void validateBossChallengeCompleted(){
       Badge badge = null;
       switch(Dungeon.depth) {
           case 5:
               badge = Badge.BOSS_CHALLENGE_1;
               break;
           case 10:
               badge = Badge.BOSS_CHALLENGE_2;
               break;
           case 15:
               badge = Badge.BOSS_CHALLENGE_3;
               break;
           case 20:
               badge = Badge.BOSS_CHALLENGE_4;
               break;
           case 25:
               badge = Badge.BOSS_CHALLENGE_5;
               break;
       }
       if (badge != null) {
           local.add(badge);
           displayBadge(badge);
       }
   }

}