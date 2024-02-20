class Snippet {
    public static FloatBuffer createSet(int size){
        return ByteBuffer.allocateDirect(size * 16 * Float.SIZE / 8).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }
}