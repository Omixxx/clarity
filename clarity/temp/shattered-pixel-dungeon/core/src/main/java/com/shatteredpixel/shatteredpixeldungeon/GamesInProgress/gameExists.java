class Snippet {
    public static boolean gameExists(int slot){
        return FileUtils.dirExists(gameFolder(slot)) && FileUtils.fileLength(gameFile(slot)) > 1;
    }
}