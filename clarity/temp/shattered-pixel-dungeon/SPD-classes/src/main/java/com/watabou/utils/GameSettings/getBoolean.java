class Snippet {
      public static boolean getBoolean(String key, boolean defValue){
          try {
              return get().getBoolean(key, defValue);
          } catch (Exception e) {
              Game.reportException(e);
              return defValue;
          }
      }
}