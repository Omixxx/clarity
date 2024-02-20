class Snippet {
        public static Texture create(int width, int height, byte[] pixels){
            Texture tex = new Texture();
            tex.pixels(width, height, pixels);
            return tex;
        }
}