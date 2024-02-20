class Snippet {
   public static void validateItemsCrafted(){
       Badge badge = null;
       if (!local.contains(Badge.ITEMS_CRAFTED_1) && Statistics.itemsCrafted >= 3) {
           badge = Badge.ITEMS_CRAFTED_1;
           local.add(badge);
       }
       if (!local.contains(Badge.ITEMS_CRAFTED_2) && Statistics.itemsCrafted >= 8) {
           if (badge != null)
               unlock(badge);
           badge = Badge.ITEMS_CRAFTED_2;
           local.add(badge);
       }
       if (!local.contains(Badge.ITEMS_CRAFTED_3) && Statistics.itemsCrafted >= 15) {
           if (badge != null)
               unlock(badge);
           badge = Badge.ITEMS_CRAFTED_3;
           local.add(badge);
       }
       if (!local.contains(Badge.ITEMS_CRAFTED_4) && Statistics.itemsCrafted >= 24) {
           if (badge != null)
               unlock(badge);
           badge = Badge.ITEMS_CRAFTED_4;
           local.add(badge);
       }
       if (!local.contains(Badge.ITEMS_CRAFTED_5) && Statistics.itemsCrafted >= 35) {
           if (badge != null)
               unlock(badge);
           badge = Badge.ITEMS_CRAFTED_5;
           local.add(badge);
       }
       displayBadge(badge);
   }
}