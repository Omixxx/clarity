class Snippet {
   public void valueM3(float[] value){
       Gdx.gl.glUniformMatrix3fv(location, 1, false, value, 0);
   }
}