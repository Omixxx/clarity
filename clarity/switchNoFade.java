class Snippet {
        public static void switchNoFade(Class<? extends PixelScene> c, SceneChangeCallback callback){
            PixelScene.noFade = true;
            switchScene(c, callback);
        }

}