class Snippet {
    public static boolean deleteDir(String name){
        FileHandle dir = getFileHandle(name);
        if (dir == null || !dir.isDirectory()) {
            return false;
        } else {
            return dir.deleteDirectory();
        }
    }

}