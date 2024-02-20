class Snippet {
   public void restoreFromBundle(Bundle bundle){
       if (bundle.contains(CAUSE)) {
           cause = bundle.getClass(CAUSE);
       } else {
           cause = null;
       }
       win = bundle.getBoolean(WIN);
       score = bundle.getInt(SCORE);
       customSeed = bundle.getString(SEED);
       daily = bundle.getBoolean(DAILY);
       heroClass = bundle.getEnum(CLASS, HeroClass.class);
       armorTier = bundle.getInt(TIER);
       herolevel = bundle.getInt(LEVEL);
       depth = bundle.getInt(DEPTH);
       ascending = bundle.getBoolean(ASCEND);
       if (bundle.contains(DATE)) {
           date = bundle.getString(DATE);
           version = bundle.getString(VERSION);
       } else {
           date = version = null;
       }
       if (bundle.contains(DATA))
           gameData = bundle.getBundle(DATA);
       if (bundle.contains(ID))
           gameID = bundle.getString(ID);
       if (gameID == null)
           gameID = UUID.randomUUID().toString();
   }
}