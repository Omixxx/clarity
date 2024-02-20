class Snippet {
    public static void SFXVol(int value){
        Sample.INSTANCE.volume(value * value / 100f);
        put(KEY_SFX_VOL, value);
    }
}