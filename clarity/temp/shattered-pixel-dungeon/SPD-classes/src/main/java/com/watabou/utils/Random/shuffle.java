class Snippet {
       public static synchronized void shuffle(List<? extends T> list){
           Collections.shuffle(list, generators.peek());
       }
}