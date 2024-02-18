class Snippet {
        public static List<T> buildPath(Collection<T> nodes, T from, T to){
            List<T> path = new ArrayList<>();
            T room = from;
            while (room != to) {
                int min = room.distance();
                T next = null;
                Collection<? extends Node> edges = room.edges();
                for (Node edge : edges) {
                    int distance = edge.distance();
                    if (distance < min) {
                        min = distance;
                        next = (T) edge;
                    }
                }
                if (next == null) {
                    return null;
                }
                path.add(next);
                room = next;
            }
            return path;
        }

}