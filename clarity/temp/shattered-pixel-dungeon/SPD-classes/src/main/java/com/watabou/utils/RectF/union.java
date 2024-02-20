class Snippet {
   public RectF union(RectF other){
       RectF result = new RectF();
       result.left = Math.min(left, other.left);
       result.right = Math.max(right, other.right);
       result.top = Math.min(top, other.top);
       result.bottom = Math.max(bottom, other.bottom);
       return result;
   }
}