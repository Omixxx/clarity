class Snippet {
     public int compare(Record lhs, Record rhs){
         //this covers custom seeded runs and dailies
         if (rhs.customSeed.isEmpty() && !lhs.customSeed.isEmpty()) {
             return +1;
         } else if (lhs.customSeed.isEmpty() && !rhs.customSeed.isEmpty()) {
             return -1;
         }
         int result = (int) Math.signum(rhs.score - lhs.score);
         if (result == 0) {
             return (int) Math.signum(rhs.gameID.hashCode() - lhs.gameID.hashCode());
         } else {
             return result;
         }
     }
}