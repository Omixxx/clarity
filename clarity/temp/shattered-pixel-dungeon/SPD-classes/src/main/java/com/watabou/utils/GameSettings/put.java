class Snippet {
      public static void put(String key, int value){
          get().putInteger(key, value);
          get().flush();
      }
}