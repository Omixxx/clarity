class Snippet {
   protected void updateValues(float progress){
       camera.scroll = PointF.inter(start, end, progress);
   }
}