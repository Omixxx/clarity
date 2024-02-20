class Snippet {
    public static synchronized void unuse(){
        curScript = null;
        curScriptClass = null;
    }
}