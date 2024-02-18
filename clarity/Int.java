class Snippet {
      public static int Int(int min, int max){
          return min + Int(max - min);
      }

}