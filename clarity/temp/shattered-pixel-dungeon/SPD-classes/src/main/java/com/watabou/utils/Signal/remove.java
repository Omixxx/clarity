class Snippet {
    public synchronized void remove(Listener<T> listener){
        listeners.remove(listener);
    }
}