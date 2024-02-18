class Snippet {
       public void drawQuadSet(Vertexbuffer buffer, int length, int offset){
           if (length == 0) {
               return;
           }
           buffer.updateGLData();
           buffer.bind();
           aXY.vertexBuffer(2, 4, 0);
           aUV.vertexBuffer(2, 4, 2);
           buffer.release();
           Gdx.gl20.glDrawElements(Gdx.gl20.GL_TRIANGLES, Quad.SIZE * length, Gdx.gl20.GL_UNSIGNED_SHORT, Quad.SIZE * Short.SIZE / 8 * offset);
       }

}