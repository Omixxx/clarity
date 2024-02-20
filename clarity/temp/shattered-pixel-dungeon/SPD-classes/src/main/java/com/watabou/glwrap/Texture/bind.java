class Snippet {
  public void bind(){
      if (id == -1) {
          generate();
      }
      if (id != bound_id) {
          Gdx.gl.glBindTexture(Gdx.gl.GL_TEXTURE_2D, id);
          bound_id = id;
      }
  }
}