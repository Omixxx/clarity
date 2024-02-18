class Snippet {
     public void filter(int minMode, int maxMode){
         bind();
         Gdx.gl.glTexParameterf(Gdx.gl.GL_TEXTURE_2D, Gdx.gl.GL_TEXTURE_MIN_FILTER, minMode);
         Gdx.gl.glTexParameterf(Gdx.gl.GL_TEXTURE_2D, Gdx.gl.GL_TEXTURE_MAG_FILTER, maxMode);
     }

}