class Snippet {
    public static void captureCursor(boolean captured){
        cursorCaptured = captured;
        if (captured) {
            Gdx.input.setCursorCatched(true);
        } else {
            if (ControllerHandler.controllerPointerActive()) {
                ControllerHandler.setControllerPointer(true);
                ControllerHandler.updateControllerPointer(new PointF(Game.width / 2f, Game.height / 2f), false);
            } else {
                Gdx.input.setCursorCatched(false);
            }
        }
    }
}