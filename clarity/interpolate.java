class Snippet {
      public static int interpolate(float p, int... colors){
          if (p <= 0) {
              return colors[0];
          } else if (p >= 1) {
              return colors[colors.length - 1];
          }
          int segment = (int) ((colors.length - 1) * p);
          return interpolate(colors[segment], colors[segment + 1], (p * (colors.length - 1)) % 1);
      }

}