class Snippet {
        public static void bundleToFile(String fileName, Bundle bundle) throws IOException{
            try {
                FileHandle file = getFileHandle(fileName);
                //write to a temp file, then move the files.
                // This helps prevent save corruption if writing is interrupted
                if (file.exists()) {
                    FileHandle temp = getFileHandle(fileName + ".tmp");
                    bundleToStream(temp.write(false), bundle);
                    file.delete();
                    temp.moveTo(file);
                } else {
                    bundleToStream(file.write(false), bundle);
                }
            } catch (GdxRuntimeException e) {
                //game classes expect an IO exception, so wrap the GDX exception in that
                throw new IOException(e);
            }
        }

}