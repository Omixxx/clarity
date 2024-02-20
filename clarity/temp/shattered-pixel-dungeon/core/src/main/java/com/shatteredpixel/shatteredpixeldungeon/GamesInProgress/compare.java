class Snippet {
     public int compare(GamesInProgress.Info lhs, GamesInProgress.Info rhs){
         int lScore = (lhs.level * lhs.maxDepth * 100) + lhs.goldCollected;
         int rScore = (rhs.level * rhs.maxDepth * 100) + rhs.goldCollected;
         return (int) Math.signum(rScore - lScore);
     }
}