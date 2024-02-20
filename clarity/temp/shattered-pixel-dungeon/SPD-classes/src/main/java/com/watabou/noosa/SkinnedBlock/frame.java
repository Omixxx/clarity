class Snippet {
   public void frame(RectF frame){
       scaleX = 1;
       scaleY = 1;
       offsetX = 0;
       offsetY = 0;
       super.frame(new RectF(0, 0, 1, 1));
   }
}