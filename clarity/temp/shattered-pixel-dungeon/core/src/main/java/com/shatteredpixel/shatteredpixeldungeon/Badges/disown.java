class Snippet {
    public static void disown(Badge badge){
        loadGlobal();
        global.remove(badge);
        saveNeeded = true;
    }
}