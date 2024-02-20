class Snippet {
  public void save(){
      Bundle bundle = new Bundle();
      bundle.put(RECORDS, records);
      bundle.put(LATEST, lastRecord);
      bundle.put(TOTAL, totalNumber);
      bundle.put(WON, wonNumber);
      bundle.put(LATEST_DAILY, latestDaily);
      long[] dates = new long[dailyScoreHistory.size()];
      int[] scores = new int[dailyScoreHistory.size()];
      int i = 0;
      for (Long l : dailyScoreHistory.keySet()) {
          dates[i] = l;
          scores[i] = dailyScoreHistory.get(l);
          i++;
      }
      bundle.put(DAILY_HISTORY_DATES, dates);
      bundle.put(DAILY_HISTORY_SCORES, scores);
      try {
          FileUtils.bundleToFile(RANKINGS_FILE, bundle);
      } catch (IOException e) {
          ShatteredPixelDungeon.reportException(e);
      }
  }
}