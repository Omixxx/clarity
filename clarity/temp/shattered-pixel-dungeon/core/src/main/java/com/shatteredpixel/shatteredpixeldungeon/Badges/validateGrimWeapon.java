class Snippet {
   public static void validateGrimWeapon(){
       if (!local.contains(Badge.GRIM_WEAPON)) {
           Badge badge = Badge.GRIM_WEAPON;
           local.add(badge);
           displayBadge(badge);
       }
   }
}