class Snippet {
     public static synchronized int Int(int max){
         return max > 0 ? generators.peek().nextInt(max) : 0;
     }
}