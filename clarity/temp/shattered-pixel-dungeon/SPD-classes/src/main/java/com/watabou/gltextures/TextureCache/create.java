class Snippet {
         public static synchronized SmartTexture create(Object key, int width, int height){
             if (all.containsKey(key)) {
                 return all.get(key);
             } else {
                 SmartTexture tx = new SmartTexture(new Pixmap(width, height, Pixmap.Format.RGBA8888));
                 tx.filter(Texture.LINEAR, Texture.LINEAR);
                 tx.wrap(Texture.CLAMP, Texture.CLAMP);
                 all.put(key, tx);
                 return tx;
             }
         }
}