class Snippet {
   public static int activeChallenges(){
       int chCount = 0;
       for (int ch : Challenges.MASKS) {
           if ((Dungeon.challenges & ch) != 0)
               chCount++;
       }
       return chCount;
   }

}