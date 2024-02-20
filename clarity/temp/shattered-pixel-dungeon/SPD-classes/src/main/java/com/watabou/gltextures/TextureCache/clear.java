class Snippet {
    public static synchronized void clear(){
        for (Texture txt : all.values()) {
            txt.delete();
        }
        all.clear();
    }
}