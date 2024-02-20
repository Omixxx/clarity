class Snippet {
   public static int firstEmpty(){
       for (int i = 1; i <= MAX_SLOTS; i++) {
           if (check(i) == null)
               return i;
       }
       return -1;
   }
}