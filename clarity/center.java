class Snippet {
   public PointF center(Visual v){
       return new PointF(x + (width() - v.width()) / 2f, y + (height() - v.height()) / 2f);
   }

}