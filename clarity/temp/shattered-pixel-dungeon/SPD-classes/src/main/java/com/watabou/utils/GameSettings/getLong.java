class Snippet {
      public static long getLong(String key, long defValue){
          return getLong(key, defValue, Long.MIN_VALUE, Long.MAX_VALUE);
      }
}