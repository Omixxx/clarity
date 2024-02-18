class Snippet {
       public void vertexPointer(int size, int stride, FloatBuffer ptr){
           Gdx.gl.glVertexAttribPointer(location, size, Gdx.gl.GL_FLOAT, false, stride * 4, ptr);
       }

}