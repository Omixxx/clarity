class Snippet {
   public static void validatePiranhasKilled(){
       Badge badge = null;
       if (!local.contains(Badge.PIRANHAS) && Statistics.piranhasKilled >= 6) {
           badge = Badge.PIRANHAS;
           local.add(badge);
       }
       displayBadge(badge);
   }
}