class Snippet {
    public static void brightness(int value){
        put(KEY_BRIGHTNESS, value);
        GameScene.updateFog();
    }
}