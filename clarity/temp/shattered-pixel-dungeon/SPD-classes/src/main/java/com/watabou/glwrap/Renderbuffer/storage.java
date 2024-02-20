class Snippet {
       public void storage(int format, int width, int height){
           Gdx.gl.glRenderbufferStorage(Gdx.gl.GL_RENDERBUFFER, format, width, height);
       }
}