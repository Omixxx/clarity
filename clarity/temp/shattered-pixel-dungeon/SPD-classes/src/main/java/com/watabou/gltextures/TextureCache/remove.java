class Snippet {
     public static synchronized void remove(Object key){
         SmartTexture tx = all.get(key);
         if (tx != null) {
             all.remove(key);
             tx.delete();
         }
     }
}