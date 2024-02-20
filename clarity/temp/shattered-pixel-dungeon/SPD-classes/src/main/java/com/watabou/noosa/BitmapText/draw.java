class Snippet {
  public void draw(){
      super.draw();
      if (dirty) {
          updateVertices();
          ((Buffer) quads).limit(quads.position());
          if (buffer == null)
              buffer = new Vertexbuffer(quads);
          else
              buffer.updateVertices(quads);
      }
      NoosaScript script = NoosaScript.get();
      font.texture.bind();
      script.camera(camera());
      script.uModel.valueM4(matrix);
      script.lighting(rm, gm, bm, am, ra, ga, ba, aa);
      script.drawQuadSet(buffer, realLength, 0);
  }
}