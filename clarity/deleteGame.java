class Snippet {
      public static void deleteGame(int save, boolean deleteLevels){
          if (deleteLevels) {
              String folder = GamesInProgress.gameFolder(save);
              for (String file : FileUtils.filesInDir(folder)) {
                  if (file.contains("depth")) {
                      FileUtils.deleteFile(folder + "/" + file);
                  }
              }
          }
          FileUtils.overwriteFile(GamesInProgress.gameFile(save), 1);
          GamesInProgress.delete(save);
      }

}