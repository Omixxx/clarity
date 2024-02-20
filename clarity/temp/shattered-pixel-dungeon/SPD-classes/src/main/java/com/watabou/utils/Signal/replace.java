class Snippet {
    public synchronized void replace(Listener<T> listener){
        removeAll();
        add(listener);
    }
}