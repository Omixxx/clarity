class Snippet {
    public static ShortBuffer getIndices(int size){
        if (size > indexSize) {
            indexSize = size;
            indices = ByteBuffer.allocateDirect(size * SIZE * Short.SIZE / 8).order(ByteOrder.nativeOrder()).asShortBuffer();
            short[] values = new short[size * 6];
            int pos = 0;
            int limit = size * 4;
            for (int ofs = 0; ofs < limit; ofs += 4) {
                values[pos++] = (short) (ofs + 0);
                values[pos++] = (short) (ofs + 1);
                values[pos++] = (short) (ofs + 2);
                values[pos++] = (short) (ofs + 0);
                values[pos++] = (short) (ofs + 2);
                values[pos++] = (short) (ofs + 3);
            }
            indices.put(values);
            ((Buffer) indices).position(0);
        }
        return indices;
    }
}