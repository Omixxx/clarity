class Snippet {
    public static void setControllerPointer(boolean active){
        if (active)
            controllerActive = true;
        if (controllerPointerActive == active)
            return;
        controllerPointerActive = active;
        if (active) {
            Gdx.input.setCursorCatched(true);
            controllerPointerPos = new PointF(PointerEvent.currentHoverPos());
        } else if (!Cursor.isCursorCaptured()) {
            Gdx.input.setCursorCatched(false);
            Gdx.input.setCursorPosition((int) controllerPointerPos.x, (int) controllerPointerPos.y);
        }
    }

}