class Snippet {
   public static void releaseIndices(){
       Gdx.gl.glBindBuffer(Gdx.gl.GL_ELEMENT_ARRAY_BUFFER, 0);
   }
}