class Snippet {
    public static void ignoreSilentMode(boolean value){
        put(KEY_IGNORE_SILENT, value);
        Game.platform.setHonorSilentSwitch(!value);
    }
}