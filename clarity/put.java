class Snippet {
      public synchronized T put(int key, T value){
          return super.put(key, value);
      }

}