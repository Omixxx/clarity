class Snippet {
        public static int getStep(int from, int to, boolean[] passable){
            if (!buildDistanceMap(from, to, passable)) {
                return -1;
            }
            // From the starting position we are making one step downwards
            int minD = distance[from];
            int best = from;
            int step, stepD;
            for (int i = 0; i < dir.length; i++) {
                if ((stepD = distance[step = from + dir[i]]) < minD) {
                    minD = stepD;
                    best = step;
                }
            }
            return best;
        }
}