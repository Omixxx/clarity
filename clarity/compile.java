class Snippet {
  public void compile(){
      Gdx.gl.glCompileShader(handle);
      IntBuffer status = BufferUtils.newIntBuffer(1);
      Gdx.gl.glGetShaderiv(handle, Gdx.gl.GL_COMPILE_STATUS, status);
      if (status.get() == Gdx.gl.GL_FALSE) {
          throw new Error(Gdx.gl.glGetShaderInfoLog(handle));
      }
  }

}