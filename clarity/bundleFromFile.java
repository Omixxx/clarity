class Snippet {
      public static Bundle bundleFromFile(String fileName) throws IOException{
          try {
              FileHandle file = getFileHandle(fileName);
              if (!file.exists() || file.isDirectory() || file.length() == 0) {
                  throw new IOException("file does not exist!");
              }
              return bundleFromStream(file.read());
          } catch (GdxRuntimeException e) {
              //game classes expect an IO exception, so wrap the GDX exception in that
              throw new IOException(e);
          }
      }

}