class Snippet {
    public static void fail(Object cause){
        if (WndResurrect.instance == null) {
            updateLevelExplored();
            Statistics.gameWon = false;
            Rankings.INSTANCE.submit(false, cause);
        }
    }
}