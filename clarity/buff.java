class Snippet {
    public synchronized T buff(Class<T> c){
        for (Buff b : buffs) {
            if (b.getClass() == c) {
                return (T) b;
            }
        }
        return null;
    }

}