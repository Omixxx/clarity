class Snippet {
  protected void updateMatrix(){
      super.updateMatrix();
      //sometimes the font is rendered oddly, so we offset here to put it in the correct spot
      if (renderedHeight != height) {
          Matrix.translate(matrix, 0, Math.round(height - renderedHeight));
      }
  }
}