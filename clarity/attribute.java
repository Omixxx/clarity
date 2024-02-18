class Snippet {
   public Attribute attribute(String name){
       return new Attribute(Gdx.gl.glGetAttribLocation(handle, name));
   }

}