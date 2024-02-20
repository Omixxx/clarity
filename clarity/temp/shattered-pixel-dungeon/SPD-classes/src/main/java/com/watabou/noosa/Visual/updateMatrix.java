class Snippet {
  protected void updateMatrix(){
      Matrix.setIdentity(matrix);
      Matrix.translate(matrix, x, y);
      if (origin.x != 0 || origin.y != 0)
          Matrix.translate(matrix, origin.x, origin.y);
      if (angle != 0) {
          Matrix.rotate(matrix, angle);
      }
      if (scale.x != 1 || scale.y != 1) {
          Matrix.scale(matrix, scale.x, scale.y);
      }
      if (origin.x != 0 || origin.y != 0)
          Matrix.translate(matrix, -origin.x, -origin.y);
  }
}