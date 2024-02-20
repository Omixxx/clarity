class Snippet {
        private static boolean buildDistanceMap(int from, int to, boolean[] passable){
            if (from == to) {
                return false;
            }
            System.arraycopy(maxVal, 0, distance, 0, maxVal.length);
            boolean pathFound = false;
            int head = 0;
            int tail = 0;
            // Add to queue
            queue[tail++] = to;
            distance[to] = 0;
            while (head < tail) {
                // Remove from queue
                int step = queue[head++];
                if (step == from) {
                    pathFound = true;
                    break;
                }
                int nextDistance = distance[step] + 1;
                int start = (step % width == 0 ? 3 : 0);
                int end = ((step + 1) % width == 0 ? 3 : 0);
                for (int i = start; i < dirLR.length - end; i++) {
                    int n = step + dirLR[i];
                    if (n == from || (n >= 0 && n < size && passable[n] && (distance[n] > nextDistance))) {
                        // Add to queue
                        queue[tail++] = n;
                        distance[n] = nextDistance;
                    }
                }
            }
            return pathFound;
        }
}