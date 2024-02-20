class Snippet {
    public static void seamlessResetScene(SceneChangeCallback callback){
        if (scene() instanceof PixelScene) {
            ((PixelScene) scene()).saveWindows();
            switchNoFade((Class<? extends PixelScene>) sceneClass, callback);
        } else {
            resetScene();
        }
    }
}