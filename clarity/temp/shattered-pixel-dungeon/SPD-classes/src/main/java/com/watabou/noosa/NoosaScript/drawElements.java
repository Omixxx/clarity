class Snippet {
       public void drawElements(FloatBuffer vertices, ShortBuffer indices, int size){
           ((Buffer) vertices).position(0);
           aXY.vertexPointer(2, 4, vertices);
           ((Buffer) vertices).position(2);
           aUV.vertexPointer(2, 4, vertices);
           Quad.releaseIndices();
           Gdx.gl20.glDrawElements(Gdx.gl20.GL_TRIANGLES, size, Gdx.gl20.GL_UNSIGNED_SHORT, indices);
           Quad.bindIndices();
       }
}