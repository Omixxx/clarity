class Snippet {
    public static void validateChampion(int challenges){
        if (challenges == 0)
            return;
        Badge badge = null;
        if (challenges >= 1) {
            badge = Badge.CHAMPION_1;
        }
        if (challenges >= 3) {
            unlock(badge);
            badge = Badge.CHAMPION_2;
        }
        if (challenges >= 6) {
            unlock(badge);
            badge = Badge.CHAMPION_3;
        }
        local.add(badge);
        displayBadge(badge);
    }
}