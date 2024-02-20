class Snippet {
   public Rect shrink(int d){
       return new Rect(left + d, top + d, right - d, bottom - d);
   }
}