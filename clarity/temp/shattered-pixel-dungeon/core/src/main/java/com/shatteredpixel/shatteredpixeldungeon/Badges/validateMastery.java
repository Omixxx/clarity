class Snippet {
   public static void validateMastery(){
       Badge badge = null;
       switch(Dungeon.hero.heroClass) {
           case WARRIOR:
               badge = Badge.MASTERY_WARRIOR;
               break;
           case MAGE:
               badge = Badge.MASTERY_MAGE;
               break;
           case ROGUE:
               badge = Badge.MASTERY_ROGUE;
               break;
           case HUNTRESS:
               badge = Badge.MASTERY_HUNTRESS;
               break;
           case DUELIST:
               badge = Badge.MASTERY_DUELIST;
               break;
       }
       unlock(badge);
   }
}