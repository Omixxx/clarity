class Snippet {
      public static boolean write(Bundle bundle, OutputStream stream){
          return write(bundle, stream, compressByDefault);
      }
}