class Snippet {
        public static Font colorMarked(SmartTexture tex, int color, String chars){
            Font font = new Font(tex);
            font.splitBy(tex.bitmap, tex.height, color, chars);
            return font;
        }
}