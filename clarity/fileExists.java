class Snippet {
    public static boolean fileExists(String name){
        FileHandle file = getFileHandle(name);
        return file.exists() && !file.isDirectory() && file.length() > 0;
    }

}