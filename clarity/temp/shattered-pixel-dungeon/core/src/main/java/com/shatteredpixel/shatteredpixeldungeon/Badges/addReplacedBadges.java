class Snippet {
    public static Collection<Badge> addReplacedBadges(Collection<Badges.Badge> badges){
        for (Badge[] tierReplace : tierBadgeReplacements) {
            addLower(badges, tierReplace);
        }
        for (Badge[] metaReplace : summaryBadgeReplacements) {
            addLower(badges, metaReplace);
        }
        return badges;
    }
}