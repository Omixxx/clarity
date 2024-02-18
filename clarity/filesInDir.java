class Snippet {
    public static ArrayList<String> filesInDir(String name){
        FileHandle dir = getFileHandle(name);
        ArrayList result = new ArrayList();
        if (dir != null && dir.isDirectory()) {
            for (FileHandle file : dir.list()) {
                result.add(file.name());
            }
        }
        return result;
    }

}