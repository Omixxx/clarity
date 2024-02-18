class Snippet {
   public static void setupIndices(){
       ShortBuffer indices = getIndices(Short.MAX_VALUE);
       if (bufferIndex == -1) {
           bufferIndex = Gdx.gl.glGenBuffer();
       }
       Gdx.gl.glBindBuffer(Gdx.gl.GL_ELEMENT_ARRAY_BUFFER, bufferIndex);
       Gdx.gl.glBufferData(Gdx.gl.GL_ELEMENT_ARRAY_BUFFER, (indices.capacity() * 2), indices, Gdx.gl.GL_STATIC_DRAW);
       Gdx.gl.glBindBuffer(Gdx.gl.GL_ELEMENT_ARRAY_BUFFER, 0);
   }

}