class Snippet {
   public static void validateNoKilling(){
       if (!local.contains(Badge.NO_MONSTERS_SLAIN) && Statistics.completedWithNoKilling) {
           Badge badge = Badge.NO_MONSTERS_SLAIN;
           local.add(badge);
           displayBadge(badge);
       }
   }

}