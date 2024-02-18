class Snippet {
     public static synchronized SmartTexture createGradient(int... colors){
         final String key = "" + colors;
         if (all.containsKey(key)) {
             return all.get(key);
         } else {
             Pixmap pixmap = new Pixmap(colors.length, 1, Pixmap.Format.RGBA8888);
             for (int i = 0; i < colors.length; i++) {
                 // In the rest of the code ARGB is used
                 pixmap.drawPixel(i, 0, (colors[i] << 8) | (colors[i] >>> 24));
             }
             SmartTexture tx = new SmartTexture(pixmap);
             tx.filter(Texture.LINEAR, Texture.LINEAR);
             tx.wrap(Texture.CLAMP, Texture.CLAMP);
             all.put(key, tx);
             return tx;
         }
     }

}