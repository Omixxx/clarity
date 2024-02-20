class Snippet {
            public static void fillXY(float[] v, float x1, float x2, float y1, float y2){
                v[0] = x1;
                v[1] = y1;
                v[4] = x2;
                v[5] = y1;
                v[8] = x2;
                v[9] = y2;
                v[12] = x1;
                v[13] = y2;
            }
}