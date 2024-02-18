class Snippet {
   public static void validateGamesPlayed(){
       Badge badge = null;
       if (Rankings.INSTANCE.totalNumber >= 10 || Rankings.INSTANCE.wonNumber >= 1) {
           badge = Badge.GAMES_PLAYED_1;
       }
       if (Rankings.INSTANCE.totalNumber >= 25 || Rankings.INSTANCE.wonNumber >= 3) {
           unlock(badge);
           badge = Badge.GAMES_PLAYED_2;
       }
       if (Rankings.INSTANCE.totalNumber >= 50 || Rankings.INSTANCE.wonNumber >= 5) {
           unlock(badge);
           badge = Badge.GAMES_PLAYED_3;
       }
       if (Rankings.INSTANCE.totalNumber >= 200 || Rankings.INSTANCE.wonNumber >= 10) {
           unlock(badge);
           badge = Badge.GAMES_PLAYED_4;
       }
       if (Rankings.INSTANCE.totalNumber >= 1000 || Rankings.INSTANCE.wonNumber >= 25) {
           unlock(badge);
           badge = Badge.GAMES_PLAYED_5;
       }
       displayBadge(badge);
   }

}