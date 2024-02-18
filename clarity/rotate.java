class Snippet {
      public static void rotate(float[] m, float a){
          a *= G2RAD;
          float sin = (float) Math.sin(a);
          float cos = (float) Math.cos(a);
          float m0 = m[0];
          float m1 = m[1];
          float m4 = m[4];
          float m5 = m[5];
          m[0] = m0 * cos + m4 * sin;
          m[1] = m1 * cos + m5 * sin;
          m[4] = -m0 * sin + m4 * cos;
          m[5] = -m1 * sin + m5 * cos;
      }

}