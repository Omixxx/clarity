class Snippet {
     public boolean overlapsScreenPoint(int x, int y){
         Camera c = camera();
         if (c == null)
             return false;
         if (!c.hitTest(x, y))
             return false;
         PointF p = c.screenToCamera(x, y);
         return overlapsPoint(p.x, p.y);
     }

}