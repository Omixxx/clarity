class Snippet {
      public static boolean[] not(boolean[] a, boolean[] result){
          int length = a.length;
          if (result == null) {
              result = new boolean[length];
          }
          for (int i = 0; i < length; i++) {
              result[i] = !a[i];
          }
          return result;
      }
}