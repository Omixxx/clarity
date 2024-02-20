class Snippet {
   public RectF shrink(float d){
       return new RectF(left + d, top + d, right - d, bottom - d);
   }
}