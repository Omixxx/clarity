class Snippet {
   public static void clear(){
       synchronized (buffers) {
           for (Vertexbuffer buf : buffers.toArray(new Vertexbuffer[0])) {
               buf.delete();
           }
       }
   }
}