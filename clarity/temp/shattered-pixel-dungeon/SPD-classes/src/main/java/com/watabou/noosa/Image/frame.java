class Snippet {
   public void frame(RectF frame){
       this.frame = frame;
       width = frame.width() * texture.width;
       height = frame.height() * texture.height;
       updateFrame();
       updateVertices();
   }
}