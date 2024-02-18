class Snippet {
      public static void skewX(float[] m, float a){
          double t = Math.tan(a * G2RAD);
          m[4] += -m[0] * t;
          m[5] += -m[1] * t;
      }

}