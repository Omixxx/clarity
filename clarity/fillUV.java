class Snippet {
            public static void fillUV(float[] v, float u1, float u2, float v1, float v2){
                v[2] = u1;
                v[3] = v1;
                v[6] = u2;
                v[7] = v1;
                v[10] = u2;
                v[11] = v2;
                v[14] = u1;
                v[15] = v2;
            }

}