class Snippet {
     public static synchronized void pushGenerator(long seed){
         generators.push(new java.util.Random(scrambleSeed(seed)));
     }

}