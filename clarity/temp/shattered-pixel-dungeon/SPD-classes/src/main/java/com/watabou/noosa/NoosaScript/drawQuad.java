class Snippet {
   public void drawQuad(FloatBuffer vertices){
       ((Buffer) vertices).position(0);
       aXY.vertexPointer(2, 4, vertices);
       ((Buffer) vertices).position(2);
       aUV.vertexPointer(2, 4, vertices);
       Gdx.gl20.glDrawElements(Gdx.gl20.GL_TRIANGLES, Quad.SIZE, Gdx.gl20.GL_UNSIGNED_SHORT, 0);
   }
}