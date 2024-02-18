class Snippet {
   public static void validateItemsIdentified(){
       for (Catalog cat : Catalog.values()) {
           if (cat.allSeen()) {
               Badge b = Catalog.catalogBadges.get(cat);
               if (!isUnlocked(b)) {
                   displayBadge(b);
               }
           }
       }
       if (isUnlocked(Badge.ALL_WEAPONS_IDENTIFIED) && isUnlocked(Badge.ALL_ARMOR_IDENTIFIED) && isUnlocked(Badge.ALL_WANDS_IDENTIFIED) && isUnlocked(Badge.ALL_RINGS_IDENTIFIED) && isUnlocked(Badge.ALL_ARTIFACTS_IDENTIFIED) && isUnlocked(Badge.ALL_POTIONS_IDENTIFIED) && isUnlocked(Badge.ALL_SCROLLS_IDENTIFIED)) {
           Badge badge = Badge.ALL_ITEMS_IDENTIFIED;
           if (!isUnlocked(badge)) {
               displayBadge(badge);
           }
       }
   }

}