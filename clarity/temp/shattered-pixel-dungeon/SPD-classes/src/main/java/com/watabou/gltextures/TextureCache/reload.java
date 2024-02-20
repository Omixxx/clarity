class Snippet {
    public static synchronized void reload(){
        for (SmartTexture tx : all.values()) {
            tx.reload();
        }
    }
}