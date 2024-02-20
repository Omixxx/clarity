class Snippet {
      public static long seedForDepth(int depth, int branch){
          int lookAhead = depth;
          //Assumes depth is always 1-30, and branch is always 0 or higher
          lookAhead += 30 * branch;
          Random.pushGenerator(seed);
          for (int i = 0; i < lookAhead; i++) {
              //we don't care about these values, just need to go through them
              Random.Long();
          }
          long result = Random.Long();
          Random.popGenerator();
          return result;
      }
}