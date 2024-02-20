class Snippet {
    public static void landscape(boolean value){
        put(KEY_LANDSCAPE, value);
        ((ShatteredPixelDungeon) ShatteredPixelDungeon.instance).updateDisplaySize();
    }
}