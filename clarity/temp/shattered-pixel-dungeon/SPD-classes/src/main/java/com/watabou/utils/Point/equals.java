class Snippet {
   public boolean equals(Object obj){
       if (obj instanceof Point) {
           Point p = (Point) obj;
           return p.x == x && p.y == y;
       } else {
           return false;
       }
   }
}