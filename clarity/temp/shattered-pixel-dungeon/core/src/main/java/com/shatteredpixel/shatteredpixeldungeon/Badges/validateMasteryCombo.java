class Snippet {
    public static void validateMasteryCombo(int n){
        if (!local.contains(Badge.MASTERY_COMBO) && n == 10) {
            Badge badge = Badge.MASTERY_COMBO;
            local.add(badge);
            displayBadge(badge);
        }
    }
}