class Snippet {
    public static void fullscreen(boolean value){
        put(KEY_FULLSCREEN, value);
        ShatteredPixelDungeon.updateSystemUI();
    }
}