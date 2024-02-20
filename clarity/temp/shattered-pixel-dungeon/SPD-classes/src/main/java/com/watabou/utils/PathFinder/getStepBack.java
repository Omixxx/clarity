class Snippet {
            public static int getStepBack(int cur, int from, int lookahead, boolean[] passable, boolean canApproachFromPos){
                int d = buildEscapeDistanceMap(cur, from, lookahead, passable);
                if (d == 0)
                    return -1;
                if (!canApproachFromPos) {
                    //We can't approach the position we are retreating from
                    //re-calculate based on this, and reduce the target distance if need-be
                    int head = 0;
                    int tail = 0;
                    int newD = distance[cur];
                    BArray.setFalse(queued);
                    queue[tail++] = cur;
                    queued[cur] = true;
                    while (head < tail) {
                        int step = queue[head++];
                        if (distance[step] > newD) {
                            newD = distance[step];
                        }
                        int start = (step % width == 0 ? 3 : 0);
                        int end = ((step + 1) % width == 0 ? 3 : 0);
                        for (int i = start; i < dirLR.length - end; i++) {
                            int n = step + dirLR[i];
                            if (n >= 0 && n < size && passable[n]) {
                                if (distance[n] < distance[cur]) {
                                    passable[n] = false;
                                } else if (distance[n] >= distance[step] && !queued[n]) {
                                    // Add to queue
                                    queue[tail++] = n;
                                    queued[n] = true;
                                }
                            }
                        }
                    }
                    d = Math.min(newD, d);
                }
                for (int i = 0; i < size; i++) {
                    goals[i] = distance[i] == d;
                }
                if (!buildDistanceMap(cur, goals, passable)) {
                    return -1;
                }
                int s = cur;
                // From the starting position we are making one step downwards
                int minD = distance[s];
                int mins = s;
                for (int i = 0; i < dir.length; i++) {
                    int n = s + dir[i];
                    int thisD = distance[n];
                    if (thisD < minD) {
                        minD = thisD;
                        mins = n;
                    }
                }
                return mins;
            }
}