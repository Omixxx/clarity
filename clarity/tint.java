class Snippet {
   public void tint(int color){
       tint(color & 0xFFFFFF, ((color >> 24) & 0xFF) / (float) 0xFF);
   }

}