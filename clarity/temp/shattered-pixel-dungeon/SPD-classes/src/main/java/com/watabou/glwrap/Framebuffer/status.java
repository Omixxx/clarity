class Snippet {
  public boolean status(){
      bind();
      return Gdx.gl.glCheckFramebufferStatus(Gdx.gl.GL_FRAMEBUFFER) == Gdx.gl.GL_FRAMEBUFFER_COMPLETE;
  }
}