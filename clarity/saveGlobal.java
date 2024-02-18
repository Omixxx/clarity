class Snippet {
    public static void saveGlobal(boolean force){
        if (saveNeeded || force) {
            Bundle bundle = new Bundle();
            store(bundle, global);
            try {
                FileUtils.bundleToFile(BADGES_FILE, bundle);
                saveNeeded = false;
            } catch (IOException e) {
                ShatteredPixelDungeon.reportException(e);
            }
        }
    }

}