class Snippet {
    public static void musicVol(int value){
        Music.INSTANCE.volume(value * value / 100f);
        put(KEY_MUSIC_VOL, value);
    }
}