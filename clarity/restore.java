class Snippet {
    public static void restore(Bundle bundle){
        for (LimitedDrops lim : values()) {
            if (bundle.contains(lim.name())) {
                lim.count = bundle.getInt(lim.name());
            } else {
                lim.count = 0;
            }
        }
        //pre-v2.2.0 saves
        if (Dungeon.version < 750 && Dungeon.isChallenged(Challenges.NO_SCROLLS) && UPGRADE_SCROLLS.count > 0) {
            //we now count SOU fully, and just don't drop every 2nd one
            UPGRADE_SCROLLS.count += UPGRADE_SCROLLS.count - 1;
        }
    }

}