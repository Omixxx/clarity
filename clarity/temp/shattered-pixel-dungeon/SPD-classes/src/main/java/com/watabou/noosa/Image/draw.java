class Snippet {
  public void draw(){
      if (texture == null || (!dirty && buffer == null))
          return;
      super.draw();
      if (dirty) {
          ((Buffer) verticesBuffer).position(0);
          verticesBuffer.put(vertices);
          if (buffer == null)
              buffer = new Vertexbuffer(verticesBuffer);
          else
              buffer.updateVertices(verticesBuffer);
          dirty = false;
      }
      NoosaScript script = script();
      texture.bind();
      script.camera(camera());
      script.uModel.valueM4(matrix);
      script.lighting(rm, gm, bm, am, ra, ga, ba, aa);
      script.drawQuad(buffer);
  }
}