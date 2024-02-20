class Snippet {
    public static void removeKeyListener(Signal.Listener<KeyEvent> listener){
        keySignal.remove(listener);
    }
}