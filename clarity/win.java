class Snippet {
    public static void win(Object cause){
        updateLevelExplored();
        Statistics.gameWon = true;
        hero.belongings.identify();
        Rankings.INSTANCE.submit(true, cause);
    }

}