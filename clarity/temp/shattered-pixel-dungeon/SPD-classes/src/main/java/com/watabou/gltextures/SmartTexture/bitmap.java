class Snippet {
   public void bitmap(Pixmap bitmap){
       super.bitmap(bitmap);
       this.bitmap = bitmap;
       width = bitmap.getWidth();
       height = bitmap.getHeight();
   }
}