class Snippet {
    public static void soundFx(boolean value){
        Sample.INSTANCE.enable(value);
        put(KEY_SOUND_FX, value);
    }
}