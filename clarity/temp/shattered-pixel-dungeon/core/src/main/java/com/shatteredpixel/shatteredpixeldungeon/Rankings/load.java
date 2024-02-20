class Snippet {
  public void load(){
      if (records != null) {
          return;
      }
      records = new ArrayList<>();
      try {
          Bundle bundle = FileUtils.bundleFromFile(RANKINGS_FILE);
          for (Bundlable record : bundle.getCollection(RECORDS)) {
              records.add((Record) record);
          }
          lastRecord = bundle.getInt(LATEST);
          totalNumber = bundle.getInt(TOTAL);
          if (totalNumber == 0) {
              totalNumber = records.size();
          }
          wonNumber = bundle.getInt(WON);
          if (wonNumber == 0) {
              for (Record rec : records) {
                  if (rec.win) {
                      wonNumber++;
                  }
              }
          }
          if (bundle.contains(LATEST_DAILY)) {
              latestDaily = (Record) bundle.get(LATEST_DAILY);
              dailyScoreHistory.clear();
              int[] scores = bundle.getIntArray(DAILY_HISTORY_SCORES);
              int i = 0;
              long latestDate = 0;
              for (long date : bundle.getLongArray(DAILY_HISTORY_DATES)) {
                  dailyScoreHistory.put(date, scores[i]);
                  if (date > latestDate)
                      latestDate = date;
                  i++;
              }
              if (latestDate > SPDSettings.lastDaily()) {
                  SPDSettings.lastDaily(latestDate);
              }
          }
      } catch (IOException e) {
      }
  }
}