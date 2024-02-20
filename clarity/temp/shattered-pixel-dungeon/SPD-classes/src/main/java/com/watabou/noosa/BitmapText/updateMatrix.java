class Snippet {
  protected void updateMatrix(){
      // "origin" field is ignored
      Matrix.setIdentity(matrix);
      Matrix.translate(matrix, x, y);
      Matrix.scale(matrix, scale.x, scale.y);
      Matrix.rotate(matrix, angle);
  }
}