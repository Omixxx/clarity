class Snippet {
     public void submit(boolean win, Object cause){
         load();
         Record rec = new Record();
         //we trim version to just the numbers, ignoring alpha/beta, etc.
         Pattern p = Pattern.compile("\\d+\\.\\d+\\.\\d+");
         Matcher m = p.matcher(ShatteredPixelDungeon.version);
         if (m.find()) {
             rec.version = "v" + m.group();
         } else {
             rec.version = "";
         }
         DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ROOT);
         rec.date = format.format(new Date(Game.realTime));
         rec.cause = cause instanceof Class ? (Class) cause : cause.getClass();
         rec.win = win;
         rec.heroClass = Dungeon.hero.heroClass;
         rec.armorTier = Dungeon.hero.tier();
         rec.herolevel = Dungeon.hero.lvl;
         if (Statistics.highestAscent == 0) {
             rec.depth = Statistics.deepestFloor;
             rec.ascending = false;
         } else {
             rec.depth = Statistics.highestAscent;
             rec.ascending = true;
         }
         rec.score = calculateScore();
         rec.customSeed = Dungeon.customSeedText;
         rec.daily = Dungeon.daily;
         Badges.validateHighScore(rec.score);
         INSTANCE.saveGameData(rec);
         rec.gameID = UUID.randomUUID().toString();
         if (rec.daily) {
             if (Dungeon.dailyReplay) {
                 latestDailyReplay = rec;
                 return;
             }
             latestDaily = rec;
             if (Dungeon.seed <= DungeonSeed.TOTAL_SEEDS) {
                 dailyScoreHistory.put(Dungeon.seed, rec.score);
             } else {
                 dailyScoreHistory.put(Dungeon.seed - DungeonSeed.TOTAL_SEEDS, rec.score);
             }
             save();
             return;
         }
         records.add(rec);
         Collections.sort(records, scoreComparator);
         lastRecord = records.indexOf(rec);
         int size = records.size();
         while (size > TABLE_SIZE) {
             if (lastRecord == size - 1) {
                 records.remove(size - 2);
                 lastRecord--;
             } else {
                 records.remove(size - 1);
             }
             size = records.size();
         }
         if (rec.customSeed.isEmpty()) {
             totalNumber++;
             if (win) {
                 wonNumber++;
             }
         }
         Badges.validateGamesPlayed();
         save();
     }
}