class Snippet {
   public void texture(Object tx){
       texture = tx instanceof SmartTexture ? (SmartTexture) tx : TextureCache.get(tx);
       frame(new RectF(0, 0, 1, 1));
   }

}