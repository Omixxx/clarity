class Snippet {
  public void draw(){
      super.draw();
      if (!updated.isEmpty()) {
          updateVertices();
          if (buffer == null)
              buffer = new Vertexbuffer(quads);
          else {
              if (fullUpdate) {
                  buffer.updateVertices(quads);
                  fullUpdate = false;
              } else {
                  buffer.updateVertices(quads, topLeftUpdating * 16, bottomRightUpdating * 16);
              }
          }
          topLeftUpdating = -1;
          updating.setEmpty();
      }
      NoosaScript script = script();
      texture.bind();
      script.uModel.valueM4(matrix);
      script.lighting(rm, gm, bm, am, ra, ga, ba, aa);
      script.camera(camera);
      script.drawQuadSet(buffer, size, 0);
  }
}