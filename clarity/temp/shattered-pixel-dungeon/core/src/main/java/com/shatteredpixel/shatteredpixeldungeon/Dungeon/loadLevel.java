class Snippet {
      public static Level loadLevel(int save) throws IOException{
          Dungeon.level = null;
          Actor.clear();
          Bundle bundle = FileUtils.bundleFromFile(GamesInProgress.depthFile(save, depth, branch));
          Level level = (Level) bundle.get(LEVEL);
          if (level == null) {
              throw new IOException();
          } else {
              return level;
          }
      }
}