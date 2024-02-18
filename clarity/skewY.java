class Snippet {
      public static void skewY(float[] m, float a){
          double t = Math.tan(a * G2RAD);
          m[0] += m[4] * t;
          m[1] += m[5] * t;
      }

}