class Snippet {
     public PointF screenToCamera(int x, int y){
         return new PointF((x - this.x) / zoom + scroll.x, (y - this.y) / zoom + scroll.y);
     }
}