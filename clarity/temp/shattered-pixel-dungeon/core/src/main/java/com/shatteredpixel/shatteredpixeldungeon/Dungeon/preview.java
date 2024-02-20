class Snippet {
      public static void preview(GamesInProgress.Info info, Bundle bundle){
          info.depth = bundle.getInt(DEPTH);
          info.version = bundle.getInt(VERSION);
          info.challenges = bundle.getInt(CHALLENGES);
          info.seed = bundle.getLong(SEED);
          info.customSeed = bundle.getString(CUSTOM_SEED);
          info.daily = bundle.getBoolean(DAILY);
          info.dailyReplay = bundle.getBoolean(DAILY_REPLAY);
          Hero.preview(info, bundle.getBundle(HERO));
          Statistics.preview(info, bundle);
      }
}