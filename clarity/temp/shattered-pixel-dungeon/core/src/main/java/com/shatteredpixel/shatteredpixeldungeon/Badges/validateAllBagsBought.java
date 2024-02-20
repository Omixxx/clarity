class Snippet {
    public static void validateAllBagsBought(Item bag){
        Badge badge = null;
        if (bag instanceof VelvetPouch) {
            badge = Badge.BAG_BOUGHT_VELVET_POUCH;
        } else if (bag instanceof ScrollHolder) {
            badge = Badge.BAG_BOUGHT_SCROLL_HOLDER;
        } else if (bag instanceof PotionBandolier) {
            badge = Badge.BAG_BOUGHT_POTION_BANDOLIER;
        } else if (bag instanceof MagicalHolster) {
            badge = Badge.BAG_BOUGHT_MAGICAL_HOLSTER;
        }
        if (badge != null) {
            local.add(badge);
            if (!local.contains(Badge.ALL_BAGS_BOUGHT) && local.contains(Badge.BAG_BOUGHT_VELVET_POUCH) && local.contains(Badge.BAG_BOUGHT_SCROLL_HOLDER) && local.contains(Badge.BAG_BOUGHT_POTION_BANDOLIER) && local.contains(Badge.BAG_BOUGHT_MAGICAL_HOLSTER)) {
                badge = Badge.ALL_BAGS_BOUGHT;
                local.add(badge);
                displayBadge(badge);
            }
        }
    }
}