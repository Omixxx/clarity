class Snippet {
    public static synchronized void processScrollEvents(){
        for (ScrollEvent k : scrollEvents) {
            scrollSignal.dispatch(k);
        }
        scrollEvents.clear();
    }
}