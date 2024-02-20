class Snippet {
      public static boolean levelHasBeenGenerated(int depth, int branch){
          return generatedLevels.contains(depth + 1000 * branch);
      }
}