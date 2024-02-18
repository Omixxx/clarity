class Snippet {
    public static boolean cleanTempFiles(String dirName){
        FileHandle dir = getFileHandle(dirName);
        boolean foundTemp = false;
        for (FileHandle file : dir.list()) {
            if (file.isDirectory()) {
                foundTemp = cleanTempFiles(dirName + file.name()) || foundTemp;
            } else {
                if (file.name().endsWith(".tmp")) {
                    FileHandle temp = file;
                    FileHandle original = getFileHandle(defaultFileType, "", temp.path().replace(".tmp", ""));
                    //replace the base file with the temp one if base is invalid or temp is valid and newer
                    try {
                        bundleFromStream(temp.read());
                        try {
                            bundleFromStream(original.read());
                            if (temp.lastModified() > original.lastModified()) {
                                temp.moveTo(original);
                            } else {
                                temp.delete();
                            }
                        } catch (Exception e) {
                            temp.moveTo(original);
                        }
                    } catch (Exception e) {
                        temp.delete();
                    }
                    foundTemp = true;
                }
            }
        }
        return foundTemp;
    }

}