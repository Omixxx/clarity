class Snippet {
  public void delete(){
      synchronized (buffers) {
          Gdx.gl.glDeleteBuffer(id);
          buffers.remove(this);
      }
  }

}