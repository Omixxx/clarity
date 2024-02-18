class Snippet {
      public static void overwriteFile(String name, int bytes){
          byte[] data = new byte[bytes];
          Arrays.fill(data, (byte) 1);
          getFileHandle(name).writeBytes(data, false);
      }

}