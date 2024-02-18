class Snippet {
     public static synchronized SmartTexture createSolid(int color){
         final String key = "1x1:" + color;
         if (all.containsKey(key)) {
             return all.get(key);
         } else {
             Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
             // In the rest of the code ARGB is used
             pixmap.setColor((color << 8) | (color >>> 24));
             pixmap.fill();
             SmartTexture tx = new SmartTexture(pixmap);
             all.put(key, tx);
             return tx;
         }
     }

}