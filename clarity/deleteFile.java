class Snippet {
    public static boolean deleteFile(String name){
        return getFileHandle(name).delete();
    }

}