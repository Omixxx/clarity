class Snippet {
      public static void buildDistanceMap(Collection<T> nodes, Node focus){
          for (T node : nodes) {
              node.distance(Integer.MAX_VALUE);
          }
          LinkedList<Node> queue = new LinkedList<>();
          focus.distance(0);
          queue.add(focus);
          while (!queue.isEmpty()) {
              Node node = queue.poll();
              int distance = node.distance();
              int price = node.price();
              for (Node edge : node.edges()) {
                  if (edge.distance() > distance + price) {
                      queue.add(edge);
                      edge.distance(distance + price);
                  }
              }
          }
      }
}