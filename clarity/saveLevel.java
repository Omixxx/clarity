class Snippet {
      public static void saveLevel(int save) throws IOException{
          Bundle bundle = new Bundle();
          bundle.put(LEVEL, level);
          FileUtils.bundleToFile(GamesInProgress.depthFile(save, depth, branch), bundle);
      }

}