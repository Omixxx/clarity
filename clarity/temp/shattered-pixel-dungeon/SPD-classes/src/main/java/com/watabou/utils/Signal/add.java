class Snippet {
    public synchronized void add(Listener<T> listener){
        if (!listeners.contains(listener)) {
            if (stackMode) {
                listeners.addFirst(listener);
            } else {
                listeners.addLast(listener);
            }
        }
    }
}