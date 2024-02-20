class Snippet {
   public boolean equals(Object o){
       if (super.equals(o))
           return true;
       return o instanceof PointF && (((PointF) o).x == x && ((PointF) o).y == y);
   }
}