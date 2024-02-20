class Snippet {
   public static void reset(){
       for (LimitedDrops lim : values()) {
           lim.count = 0;
       }
   }
}