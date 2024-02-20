class Snippet {
    public synchronized void dispatch(T t){
        @SuppressWarnings("unchecked")
        Listener<T>[] list = listeners.toArray(new Listener[0]);
        for (Listener<T> listener : list) {
            if (listeners.contains(listener)) {
                if (listener.onSignal(t)) {
                    return;
                }
            }
        }
    }
}