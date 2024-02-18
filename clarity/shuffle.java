class Snippet {
      public static void shuffle(U[] u, V[] v){
          for (int i = 0; i < u.length - 1; i++) {
              int j = Int(i, u.length);
              if (j != i) {
                  U ut = u[i];
                  u[i] = u[j];
                  u[j] = ut;
                  V vt = v[i];
                  v[i] = v[j];
                  v[j] = vt;
              }
          }
      }

}