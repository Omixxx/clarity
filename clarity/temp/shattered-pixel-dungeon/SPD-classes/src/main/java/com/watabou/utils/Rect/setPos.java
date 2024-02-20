class Snippet {
     public Rect setPos(int x, int y){
         return set(x, y, x + (right - left), y + (bottom - top));
     }
}