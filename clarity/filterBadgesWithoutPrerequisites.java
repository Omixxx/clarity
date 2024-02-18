class Snippet {
    public static List<Badge> filterBadgesWithoutPrerequisites(List<Badges.Badge> badges){
        for (Badge[] prereqReplace : prerequisiteBadges) {
            leaveWorst(badges, prereqReplace);
        }
        for (Badge[] tierReplace : tierBadgeReplacements) {
            leaveWorst(badges, tierReplace);
        }
        Collections.sort(badges);
        return badges;
    }

}