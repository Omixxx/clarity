class Snippet {
     public void attach(int point, Renderbuffer buffer){
         bind();
         Gdx.gl.glFramebufferRenderbuffer(Gdx.gl.GL_RENDERBUFFER, point, Gdx.gl.GL_TEXTURE_2D, buffer.id());
     }
}