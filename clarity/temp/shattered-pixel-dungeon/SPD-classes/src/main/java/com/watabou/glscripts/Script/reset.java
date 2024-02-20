class Snippet {
    public static synchronized void reset(){
        for (Script script : all.values()) {
            script.delete();
        }
        all.clear();
        curScript = null;
        curScriptClass = null;
    }
}