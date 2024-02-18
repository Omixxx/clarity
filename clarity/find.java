class Snippet {
        public static Path find(int from, int to, boolean[] passable){
            if (!buildDistanceMap(from, to, passable)) {
                return null;
            }
            Path result = new Path();
            int s = from;
            // From the starting position we are moving downwards,
            // until we reach the ending point
            do {
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
                s = mins;
                result.add(s);
            } while (s != to);
            return result;
        }

}