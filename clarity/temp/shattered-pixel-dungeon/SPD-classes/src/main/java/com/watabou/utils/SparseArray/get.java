class Snippet {
      public synchronized T get(int key, T defaultValue){
          return super.get(key, defaultValue);
      }
}