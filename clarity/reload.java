class Snippet {
   public static void reload(){
       synchronized (buffers) {
           for (Vertexbuffer buf : buffers) {
               buf.updateVertices();
               buf.updateGLData();
           }
       }
   }

}