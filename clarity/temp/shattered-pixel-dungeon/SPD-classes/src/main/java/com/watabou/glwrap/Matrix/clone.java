class Snippet {
    public static float[] clone(float[] m){
        int n = m.length;
        float[] res = new float[n];
        do {
            res[--n] = m[n];
        } while (n > 0);
        return res;
    }
}