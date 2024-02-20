class Snippet {
     public void drawQuadSet(FloatBuffer vertices, int size){
         if (size == 0) {
             return;
         }
         ((Buffer) vertices).position(0);
         aXY.vertexPointer(2, 4, vertices);
         ((Buffer) vertices).position(2);
         aUV.vertexPointer(2, 4, vertices);
         Gdx.gl20.glDrawElements(Gdx.gl20.GL_TRIANGLES, Quad.SIZE * size, Gdx.gl20.GL_UNSIGNED_SHORT, 0);
     }
}