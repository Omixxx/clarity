class Snippet {
   public RectF intersect(RectF other){
       RectF result = new RectF();
       result.left = Math.max(left, other.left);
       result.right = Math.min(right, other.right);
       result.top = Math.max(top, other.top);
       result.bottom = Math.min(bottom, other.bottom);
       return result;
   }

}