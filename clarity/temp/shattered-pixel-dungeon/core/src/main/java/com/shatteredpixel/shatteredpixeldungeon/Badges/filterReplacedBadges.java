class Snippet {
    public static List<Badge> filterReplacedBadges(boolean global){
        ArrayList<Badge> badges = new ArrayList<>(global ? Badges.global : Badges.local);
        Iterator<Badge> iterator = badges.iterator();
        while (iterator.hasNext()) {
            Badge badge = iterator.next();
            if ((!global && badge.meta) || badge.image == -1) {
                iterator.remove();
            }
        }
        Collections.sort(badges);
        return filterReplacedBadges(badges);
    }
}