class Snippet {
    public static Camera createFullscreen(float zoom){
        int w = (int) Math.ceil(Game.width / zoom);
        int h = (int) Math.ceil(Game.height / zoom);
        Camera c = new Camera((int) (Game.width - w * zoom) / 2, (int) (Game.height - h * zoom) / 2, w, h, zoom);
        c.fullScreen = true;
        return c;
    }
}