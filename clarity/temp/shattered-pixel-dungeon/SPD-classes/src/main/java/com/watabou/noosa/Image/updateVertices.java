class Snippet {
  protected void updateVertices(){
      vertices[0] = 0;
      vertices[1] = 0;
      vertices[4] = width;
      vertices[5] = 0;
      vertices[8] = width;
      vertices[9] = height;
      vertices[12] = 0;
      vertices[13] = height;
      dirty = true;
  }
}