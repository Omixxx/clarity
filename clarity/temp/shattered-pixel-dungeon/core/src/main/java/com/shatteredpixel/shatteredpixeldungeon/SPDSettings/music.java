class Snippet {
    public static void music(boolean value){
        Music.INSTANCE.enable(value);
        put(KEY_MUSIC, value);
    }
}