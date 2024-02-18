class Snippet {
   public void hardlight(int color){
       hardlight((color >> 16) / 255f, ((color >> 8) & 0xFF) / 255f, (color & 0xFF) / 255f);
   }

}