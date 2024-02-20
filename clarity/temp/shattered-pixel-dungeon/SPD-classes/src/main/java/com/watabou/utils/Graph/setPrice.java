class Snippet {
      public static void setPrice(List<T> nodes, int value){
          for (T node : nodes) {
              node.price(value);
          }
      }
}