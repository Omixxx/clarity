class Snippet {
    public static HashSet<Badge> restore(Bundle bundle){
        HashSet<Badge> badges = new HashSet<>();
        if (bundle == null)
            return badges;
        String[] names = bundle.getStringArray(BADGES);
        if (names == null)
            return badges;
        for (int i = 0; i < names.length; i++) {
            try {
                if (renamedBadges.containsKey(names[i])) {
                    names[i] = renamedBadges.get(names[i]);
                }
                if (!removedBadges.contains(names[i])) {
                    badges.add(Badge.valueOf(names[i]));
                }
            } catch (Exception e) {
                ShatteredPixelDungeon.reportException(e);
            }
        }
        addReplacedBadges(badges);
        return badges;
    }
}