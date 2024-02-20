class Snippet {
    public static void powerSaver(boolean value){
        put(KEY_POWER_SAVER, value);
        ((ShatteredPixelDungeon) ShatteredPixelDungeon.instance).updateDisplaySize();
    }
}