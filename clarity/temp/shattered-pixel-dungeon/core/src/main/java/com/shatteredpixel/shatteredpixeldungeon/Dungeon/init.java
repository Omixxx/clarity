class Snippet {
   public static void init(){
       initialVersion = version = Game.versionCode;
       challenges = SPDSettings.challenges();
       mobsToChampion = -1;
       if (daily) {
           //Ensures that daily seeds are not in the range of user-enterable seeds
           seed = SPDSettings.lastDaily() + DungeonSeed.TOTAL_SEEDS;
           DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ROOT);
           format.setTimeZone(TimeZone.getTimeZone("UTC"));
           customSeedText = format.format(new Date(SPDSettings.lastDaily()));
       } else if (!SPDSettings.customSeed().isEmpty()) {
           customSeedText = SPDSettings.customSeed();
           seed = DungeonSeed.convertFromText(customSeedText);
       } else {
           customSeedText = "";
           seed = DungeonSeed.randomSeed();
       }
       Actor.clear();
       Actor.resetNextID();
       //offset seed slightly to avoid output patterns
       Random.pushGenerator(seed + 1);
       Scroll.initLabels();
       Potion.initColors();
       Ring.initGems();
       SpecialRoom.initForRun();
       SecretRoom.initForRun();
       Generator.fullReset();
       Random.resetGenerators();
       Statistics.reset();
       Notes.reset();
       quickslot.reset();
       QuickSlotButton.reset();
       Toolbar.swappedQuickslots = false;
       depth = 1;
       branch = 0;
       generatedLevels.clear();
       gold = 0;
       energy = 0;
       droppedItems = new SparseArray<>();
       LimitedDrops.reset();
       chapters = new HashSet<>();
       Ghost.Quest.reset();
       Wandmaker.Quest.reset();
       Blacksmith.Quest.reset();
       Imp.Quest.reset();
       hero = new Hero();
       hero.live();
       Badges.reset();
       GamesInProgress.selectedClass.initHero(hero);
   }
}