class Snippet {
    public synchronized boolean keyUp(int keyCode){
        if (KeyBindings.isKeyBound(keyCode)) {
            KeyEvent.addKeyEvent(new KeyEvent(keyCode, false));
            return true;
        } else {
            return false;
        }
    }

}