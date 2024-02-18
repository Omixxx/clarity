class Snippet {
    public static void validateHighScore(int score){
        Badge badge = null;
        if (score >= 5000) {
            badge = Badge.HIGH_SCORE_1;
            local.add(badge);
        }
        if (score >= 25_000) {
            unlock(badge);
            badge = Badge.HIGH_SCORE_2;
            local.add(badge);
        }
        if (score >= 100_000) {
            unlock(badge);
            badge = Badge.HIGH_SCORE_3;
            local.add(badge);
        }
        if (score >= 250_000) {
            unlock(badge);
            badge = Badge.HIGH_SCORE_4;
            local.add(badge);
        }
        if (score >= 1_000_000) {
            unlock(badge);
            badge = Badge.HIGH_SCORE_5;
            local.add(badge);
        }
        displayBadge(badge);
    }

}