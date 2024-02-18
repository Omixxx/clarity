class Snippet {
  public void updateGLData(){
      if (updateStart == -1)
          return;
      ((Buffer) vertices).position(updateStart);
      bind();
      if (updateStart == 0 && updateEnd == vertices.limit()) {
          Gdx.gl.glBufferData(Gdx.gl.GL_ARRAY_BUFFER, vertices.limit() * 4, vertices, Gdx.gl.GL_DYNAMIC_DRAW);
      } else {
          Gdx.gl.glBufferSubData(Gdx.gl.GL_ARRAY_BUFFER, updateStart * 4, (updateEnd - updateStart) * 4, vertices);
      }
      release();
      updateStart = updateEnd = -1;
  }

}