class Snippet {
     public RectF setPos(float x, float y){
         return set(x, y, x + (right - left), y + (bottom - top));
     }
}