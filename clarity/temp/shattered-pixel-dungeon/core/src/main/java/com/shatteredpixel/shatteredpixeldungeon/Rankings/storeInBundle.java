class Snippet {
   public void storeInBundle(Bundle bundle){
       if (cause != null)
           bundle.put(CAUSE, cause);
       bundle.put(WIN, win);
       bundle.put(SCORE, score);
       bundle.put(SEED, customSeed);
       bundle.put(DAILY, daily);
       bundle.put(CLASS, heroClass);
       bundle.put(TIER, armorTier);
       bundle.put(LEVEL, herolevel);
       bundle.put(DEPTH, depth);
       bundle.put(ASCEND, ascending);
       bundle.put(DATE, date);
       bundle.put(VERSION, version);
       if (gameData != null)
           bundle.put(DATA, gameData);
       bundle.put(ID, gameID);
   }
}