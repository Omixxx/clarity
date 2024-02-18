class Snippet {
          public static Font colorMarked(SmartTexture tex, int height, int color, String chars){
              Font font = new Font(tex);
              font.splitBy(tex.bitmap, height, color, chars);
              return font;
          }

}