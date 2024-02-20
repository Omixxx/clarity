class Snippet {
       public void pixels(int w, int h, byte[] pixels){
           bind();
           ByteBuffer imageBuffer = ByteBuffer.allocateDirect(w * h).order(ByteOrder.nativeOrder());
           imageBuffer.put(pixels);
           ((Buffer) imageBuffer).position(0);
           Gdx.gl.glPixelStorei(Gdx.gl.GL_UNPACK_ALIGNMENT, 1);
           Gdx.gl.glTexImage2D(Gdx.gl.GL_TEXTURE_2D, 0, Gdx.gl.GL_ALPHA, w, h, 0, Gdx.gl.GL_ALPHA, Gdx.gl.GL_UNSIGNED_BYTE, imageBuffer);
       }
}