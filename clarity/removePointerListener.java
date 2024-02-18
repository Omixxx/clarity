class Snippet {
    public static void removePointerListener(Signal.Listener<PointerEvent> listener){
        pointerSignal.remove(listener);
    }

}