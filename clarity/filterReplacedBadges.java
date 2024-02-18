class Snippet {
    public static List<Badge> filterReplacedBadges(List<Badge> badges){
        for (Badge[] tierReplace : tierBadgeReplacements) {
            leaveBest(badges, tierReplace);
        }
        for (Badge[] metaReplace : summaryBadgeReplacements) {
            leaveBest(badges, metaReplace);
        }
        return badges;
    }

}