class Snippet {
     public static synchronized SmartTexture get(Object src){
         if (all.containsKey(src)) {
             return all.get(src);
         } else if (src instanceof SmartTexture) {
             return (SmartTexture) src;
         } else {
             SmartTexture tx = new SmartTexture(getBitmap(src));
             all.put(src, tx);
             return tx;
         }
     }
}