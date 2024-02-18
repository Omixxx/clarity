class Snippet {
   public Uniform uniform(String name){
       return new Uniform(Gdx.gl.glGetUniformLocation(handle, name));
   }

}