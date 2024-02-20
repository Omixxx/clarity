class Snippet {
  protected void updateFrame(){
      if (autoAdjust) {
          while (offsetX > texture.width) {
              offsetX -= texture.width;
          }
          while (offsetX < -texture.width) {
              offsetX += texture.width;
          }
          while (offsetY > texture.height) {
              offsetY -= texture.height;
          }
          while (offsetY < -texture.height) {
              offsetY += texture.height;
          }
      }
      float tw = 1f / texture.width;
      float th = 1f / texture.height;
      float u0 = offsetX * tw;
      float v0 = offsetY * th;
      float u1 = u0 + width * tw / scaleX;
      float v1 = v0 + height * th / scaleY;
      vertices[2] = u0;
      vertices[3] = v0;
      vertices[6] = u1;
      vertices[7] = v0;
      vertices[10] = u1;
      vertices[11] = v1;
      vertices[14] = u0;
      vertices[15] = v1;
      dirty = true;
  }
}