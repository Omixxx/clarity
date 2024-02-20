class Snippet {
    public static void activate(int index){
        Gdx.gl.glActiveTexture(Gdx.gl.GL_TEXTURE0 + index);
    }
}