class Snippet {
   public boolean inside(Point p){
       return p.x >= left && p.x < right && p.y >= top && p.y < bottom;
   }
}