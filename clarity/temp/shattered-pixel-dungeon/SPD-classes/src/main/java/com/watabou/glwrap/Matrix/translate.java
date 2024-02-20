class Snippet {
        public static void translate(float[] m, float x, float y){
            m[12] += m[0] * x + m[4] * y;
            m[13] += m[1] * x + m[5] * y;
        }
}