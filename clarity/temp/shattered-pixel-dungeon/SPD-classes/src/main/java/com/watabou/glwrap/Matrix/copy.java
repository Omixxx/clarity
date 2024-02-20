class Snippet {
      public static void copy(float[] src, float[] dst){
          int n = src.length;
          do {
              dst[--n] = src[n];
          } while (n > 0);
      }
}