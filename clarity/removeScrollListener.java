class Snippet {
    public static void removeScrollListener(Signal.Listener<ScrollEvent> listener){
        scrollSignal.remove(listener);
    }

}