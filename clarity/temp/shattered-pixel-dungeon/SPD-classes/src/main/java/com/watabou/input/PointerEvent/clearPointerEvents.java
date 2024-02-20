class Snippet {
    public static synchronized void clearPointerEvents(){
        pointerEvents.clear();
        for (PointerEvent p : activePointers.values()) {
            p.current = p.start = new PointF(-1, -1);
            pointerSignal.dispatch(p.up());
        }
        activePointers.clear();
    }
}