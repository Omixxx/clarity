class Snippet {
     private int[] trim(int start, int end){
         int len = end - start;
         int[] copy = new int[len];
         System.arraycopy(cur, start, copy, 0, len);
         return copy;
     }

}