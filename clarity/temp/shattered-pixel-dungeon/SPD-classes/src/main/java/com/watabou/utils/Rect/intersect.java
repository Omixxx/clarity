class Snippet {
   public Rect intersect(Rect other){
       Rect result = new Rect();
       result.left = Math.max(left, other.left);
       result.right = Math.min(right, other.right);
       result.top = Math.max(top, other.top);
       result.bottom = Math.min(bottom, other.bottom);
       return result;
   }
}