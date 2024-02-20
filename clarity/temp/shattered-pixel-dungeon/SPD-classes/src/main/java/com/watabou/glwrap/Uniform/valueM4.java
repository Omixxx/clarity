class Snippet {
   public void valueM4(float[] value){
       Gdx.gl.glUniformMatrix4fv(location, 1, false, value, 0);
   }
}