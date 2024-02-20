class Snippet {
      private static File getFile(File base, String name){
          File file = new File(base, name);
          if (!file.exists() || !file.isDirectory()) {
              return file;
          }
          return null;
      }
}