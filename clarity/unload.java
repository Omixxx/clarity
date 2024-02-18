class Snippet {
    public synchronized void unload(Object src){
        if (ids.containsKey(src)) {
            ids.get(src).dispose();
            ids.remove(src);
        }
    }

}