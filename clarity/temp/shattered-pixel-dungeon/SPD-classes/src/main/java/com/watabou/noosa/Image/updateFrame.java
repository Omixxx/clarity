class Snippet {
  protected void updateFrame(){
      if (flipHorizontal) {
          vertices[2] = frame.right;
          vertices[6] = frame.left;
          vertices[10] = frame.left;
          vertices[14] = frame.right;
      } else {
          vertices[2] = frame.left;
          vertices[6] = frame.right;
          vertices[10] = frame.right;
          vertices[14] = frame.left;
      }
      if (flipVertical) {
          vertices[3] = frame.bottom;
          vertices[7] = frame.bottom;
          vertices[11] = frame.top;
          vertices[15] = frame.top;
      } else {
          vertices[3] = frame.top;
          vertices[7] = frame.top;
          vertices[11] = frame.bottom;
          vertices[15] = frame.bottom;
      }
      dirty = true;
  }
}