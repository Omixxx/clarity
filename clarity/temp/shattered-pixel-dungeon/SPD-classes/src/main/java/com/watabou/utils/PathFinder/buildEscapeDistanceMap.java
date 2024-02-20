class Snippet {
          private static int buildEscapeDistanceMap(int cur, int from, int lookAhead, boolean[] passable){
              System.arraycopy(maxVal, 0, distance, 0, maxVal.length);
              int destDist = Integer.MAX_VALUE;
              int head = 0;
              int tail = 0;
              // Add to queue
              queue[tail++] = from;
              distance[from] = 0;
              int dist = 0;
              while (head < tail) {
                  // Remove from queue
                  int step = queue[head++];
                  dist = distance[step];
                  if (dist > destDist) {
                      return destDist;
                  }
                  if (step == cur) {
                      destDist = dist + lookAhead;
                  }
                  int nextDistance = dist + 1;
                  int start = (step % width == 0 ? 3 : 0);
                  int end = ((step + 1) % width == 0 ? 3 : 0);
                  for (int i = start; i < dirLR.length - end; i++) {
                      int n = step + dirLR[i];
                      if (n >= 0 && n < size && passable[n] && distance[n] > nextDistance) {
                          // Add to queue
                          queue[tail++] = n;
                          distance[n] = nextDistance;
                      }
                  }
              }
              return dist;
          }
}