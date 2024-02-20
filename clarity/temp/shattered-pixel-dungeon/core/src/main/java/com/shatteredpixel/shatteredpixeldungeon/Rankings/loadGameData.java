class Snippet {
   public void loadGameData(Record rec){
       Bundle data = rec.gameData;
       Actor.clear();
       Dungeon.hero = null;
       Dungeon.level = null;
       Generator.fullReset();
       Notes.reset();
       Dungeon.quickslot.reset();
       QuickSlotButton.reset();
       Toolbar.swappedQuickslots = false;
       if (data == null)
           return;
       Bundle handler = data.getBundle(HANDLERS);
       Scroll.restore(handler);
       Potion.restore(handler);
       Ring.restore(handler);
       Badges.loadLocal(data.getBundle(BADGES));
       Dungeon.hero = (Hero) data.get(HERO);
       Dungeon.hero.belongings.identify();
       Statistics.restoreFromBundle(data.getBundle(STATS));
       Dungeon.challenges = data.getInt(CHALLENGES);
       Dungeon.initialVersion = data.getInt(GAME_VERSION);
       if (Dungeon.initialVersion <= ShatteredPixelDungeon.v1_2_3) {
           Statistics.gameWon = rec.win;
       }
       rec.score = calculateScore();
       if (rec.gameData.contains(SEED)) {
           Dungeon.seed = rec.gameData.getLong(SEED);
           Dungeon.customSeedText = rec.gameData.getString(CUSTOM_SEED);
           Dungeon.daily = rec.gameData.getBoolean(DAILY);
           Dungeon.dailyReplay = rec.gameData.getBoolean(DAILY_REPLAY);
       } else {
           Dungeon.seed = -1;
           Dungeon.customSeedText = "";
           Dungeon.daily = Dungeon.dailyReplay = false;
       }
   }
}