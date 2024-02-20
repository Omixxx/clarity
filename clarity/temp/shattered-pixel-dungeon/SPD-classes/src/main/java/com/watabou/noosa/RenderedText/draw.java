class Snippet {
   public synchronized void draw(){
       if (font != null) {
           updateMatrix();
           TextRenderBatch.textBeingRendered = this;
           font.draw(textRenderer, text, 0, 0);
       }
   }
}