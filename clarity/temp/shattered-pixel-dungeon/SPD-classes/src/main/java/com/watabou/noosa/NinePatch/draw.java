class Snippet {
  public void draw(){
      super.draw();
      if (dirty) {
          if (buffer == null)
              buffer = new Vertexbuffer(quads);
          else
              buffer.updateVertices(quads);
          dirty = false;
      }
      NoosaScript script = NoosaScript.get();
      texture.bind();
      script.camera(camera());
      script.uModel.valueM4(matrix);
      script.lighting(rm, gm, bm, am, ra, ga, ba, aa);
      script.drawQuadSet(buffer, 9, 0);
  }
}