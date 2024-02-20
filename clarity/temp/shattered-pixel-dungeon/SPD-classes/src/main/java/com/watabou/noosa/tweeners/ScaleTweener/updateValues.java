class Snippet {
   protected void updateValues(float progress){
       visual.scale = PointF.inter(start, end, progress);
   }
}