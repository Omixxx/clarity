class Snippet {
      public static void preview(GamesInProgress.Info info, Bundle bundle){
          info.goldCollected = bundle.getInt(GOLD);
          info.maxDepth = bundle.getInt(DEEPEST);
      }

}