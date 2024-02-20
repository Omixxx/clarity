class Snippet {
   public static FloatBuffer create(){
       return ByteBuffer.allocateDirect(16 * Float.SIZE / 8).order(ByteOrder.nativeOrder()).asFloatBuffer();
   }
}