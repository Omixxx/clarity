class Snippet {
   public void bitmap(Pixmap pixmap){
       bind();
       Gdx.gl.glTexImage2D(Gdx.gl.GL_TEXTURE_2D, 0, pixmap.getGLInternalFormat(), pixmap.getWidth(), pixmap.getHeight(), 0, pixmap.getGLFormat(), pixmap.getGLType(), pixmap.getPixels());
       premultiplied = true;
   }
}