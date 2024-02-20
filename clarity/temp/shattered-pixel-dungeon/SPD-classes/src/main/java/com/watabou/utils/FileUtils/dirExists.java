class Snippet {
    public static boolean dirExists(String name){
        FileHandle dir = getFileHandle(name);
        return dir.exists() && dir.isDirectory();
    }
}