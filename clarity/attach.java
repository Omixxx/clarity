class Snippet {
   public void attach(Shader shader){
       Gdx.gl.glAttachShader(handle, shader.handle());
   }

}