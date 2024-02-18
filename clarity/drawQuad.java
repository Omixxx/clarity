class Snippet {
   public void drawQuad(Vertexbuffer buffer){
       buffer.updateGLData();
       buffer.bind();
       aXY.vertexBuffer(2, 4, 0);
       aUV.vertexBuffer(2, 4, 2);
       buffer.release();
       Gdx.gl20.glDrawElements(Gdx.gl20.GL_TRIANGLES, Quad.SIZE, Gdx.gl20.GL_UNSIGNED_SHORT, 0);
   }

}