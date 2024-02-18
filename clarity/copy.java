class Snippet {
   public void copy(Image other){
       texture = other.texture;
       frame = new RectF(other.frame);
       width = other.width;
       height = other.height;
       scale = other.scale;
       updateFrame();
       updateVertices();
   }

}