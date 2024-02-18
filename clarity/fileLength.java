class Snippet {
    public static long fileLength(String name){
        FileHandle file = getFileHandle(name);
        if (!file.exists() || file.isDirectory()) {
            return 0;
        } else {
            return file.length();
        }
    }

}