class Snippet {
       public void vertexBuffer(int size, int stride, int offset){
           Gdx.gl.glVertexAttribPointer(location, size, Gdx.gl.GL_FLOAT, false, stride * 4, offset * 4);
       }

}