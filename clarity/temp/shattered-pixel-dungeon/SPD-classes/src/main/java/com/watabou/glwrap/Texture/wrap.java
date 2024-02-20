class Snippet {
     public void wrap(int s, int t){
         bind();
         Gdx.gl.glTexParameterf(Gdx.gl.GL_TEXTURE_2D, Gdx.gl.GL_TEXTURE_WRAP_S, s);
         Gdx.gl.glTexParameterf(Gdx.gl.GL_TEXTURE_2D, Gdx.gl.GL_TEXTURE_WRAP_T, t);
     }
}