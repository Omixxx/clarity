class Snippet {
  protected void updateMatrix(){
      /*	Matrix.setIdentity( matrix );
  		Matrix.translate( matrix, -1, +1 );
  		Matrix.scale( matrix, 2f / G.width, -2f / G.height );
  		Matrix.translate( matrix, x, y );
  		Matrix.scale( matrix, zoom, zoom );
  		Matrix.translate( matrix, scroll.x, scroll.y );*/
      matrix[0] = +zoom * invW2;
      matrix[5] = -zoom * invH2;
      matrix[12] = -1 + x * invW2 - (scroll.x + shakeX) * matrix[0];
      matrix[13] = +1 - y * invH2 - (scroll.y + shakeY) * matrix[5];
  }
}