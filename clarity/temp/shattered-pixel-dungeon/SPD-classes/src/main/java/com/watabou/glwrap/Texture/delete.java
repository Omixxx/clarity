class Snippet {
  public void delete(){
      if (bound_id == id)
          bound_id = 0;
      Gdx.gl.glDeleteTexture(id);
  }
}