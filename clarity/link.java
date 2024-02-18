class Snippet {
  public void link(){
      Gdx.gl.glLinkProgram(handle);
      IntBuffer status = BufferUtils.newIntBuffer(1);
      Gdx.gl.glGetProgramiv(handle, Gdx.gl.GL_LINK_STATUS, status);
      if (status.get() == Gdx.gl.GL_FALSE) {
          Game.reportException(new RuntimeException(Gdx.gl.glGetProgramInfoLog(handle)));
      }
  }

}