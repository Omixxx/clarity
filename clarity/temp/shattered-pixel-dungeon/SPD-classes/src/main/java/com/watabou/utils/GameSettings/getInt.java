class Snippet {
      public static int getInt(String key, int defValue){
          return getInt(key, defValue, Integer.MIN_VALUE, Integer.MAX_VALUE);
      }
}