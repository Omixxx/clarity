class Snippet {
    public static void validateItemLevelAquired(Item item){
        // This method should be called:
        // 1) When an item is obtained (Item.collect)
        // 2) When an item is upgraded (ScrollOfUpgrade, ScrollOfWeaponUpgrade, ShortSword, WandOfMagicMissile)
        // 3) When an item is identified
        // Note that artifacts should never trigger this badge as they are alternatively upgraded
        if (!item.levelKnown || item instanceof Artifact) {
            return;
        }
        if (item instanceof MeleeWeapon) {
            validateDuelistUnlock();
        }
        Badge badge = null;
        if (!local.contains(Badge.ITEM_LEVEL_1) && item.level() >= 3) {
            badge = Badge.ITEM_LEVEL_1;
            local.add(badge);
        }
        if (!local.contains(Badge.ITEM_LEVEL_2) && item.level() >= 6) {
            if (badge != null)
                unlock(badge);
            badge = Badge.ITEM_LEVEL_2;
            local.add(badge);
        }
        if (!local.contains(Badge.ITEM_LEVEL_3) && item.level() >= 9) {
            if (badge != null)
                unlock(badge);
            badge = Badge.ITEM_LEVEL_3;
            local.add(badge);
        }
        if (!local.contains(Badge.ITEM_LEVEL_4) && item.level() >= 12) {
            if (badge != null)
                unlock(badge);
            badge = Badge.ITEM_LEVEL_4;
            local.add(badge);
        }
        if (!local.contains(Badge.ITEM_LEVEL_5) && item.level() >= 15) {
            if (badge != null)
                unlock(badge);
            badge = Badge.ITEM_LEVEL_5;
            local.add(badge);
        }
        displayBadge(badge);
    }

}