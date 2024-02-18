class Snippet {
      public static T element(Collection<? extends T> collection){
          int size = collection.size();
          return size > 0 ? (T) collection.toArray()[Int(size)] : null;
      }

}