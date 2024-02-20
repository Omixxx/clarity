class Snippet {
    public synchronized boolean keyDown(int keyCode){
        if (KeyBindings.isKeyBound(keyCode)) {
            KeyEvent.addKeyEvent(new KeyEvent(keyCode, true));
            return true;
        } else {
            return false;
        }
    }
}