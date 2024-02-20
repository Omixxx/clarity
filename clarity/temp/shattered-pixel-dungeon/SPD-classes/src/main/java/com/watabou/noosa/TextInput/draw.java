class Snippet {
  public void draw(){
      super.draw();
      Quad.releaseIndices();
      Script.unuse();
      Texture.clear();
      stage.draw();
      Quad.bindIndices();
      Blending.useDefault();
  }
}