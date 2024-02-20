class Snippet {
    private static void displayBadge(Badge badge){
        if (badge == null || !Dungeon.customSeedText.isEmpty()) {
            return;
        }
        if (isUnlocked(badge)) {
            if (!badge.meta) {
                GLog.h(Messages.get(Badges.class, "endorsed", badge.title()));
                GLog.newLine();
            }
        } else {
            unlock(badge);
            GLog.h(Messages.get(Badges.class, "new", badge.title() + " (" + badge.desc() + ")"));
            GLog.newLine();
            PixelScene.showBadge(badge);
        }
    }
}