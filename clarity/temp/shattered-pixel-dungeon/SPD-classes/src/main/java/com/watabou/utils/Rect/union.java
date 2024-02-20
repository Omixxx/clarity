class Snippet {
   public Rect union(Rect other){
       Rect result = new Rect();
       result.left = Math.min(left, other.left);
       result.right = Math.max(right, other.right);
       result.top = Math.min(top, other.top);
       result.bottom = Math.max(bottom, other.bottom);
       return result;
   }
}