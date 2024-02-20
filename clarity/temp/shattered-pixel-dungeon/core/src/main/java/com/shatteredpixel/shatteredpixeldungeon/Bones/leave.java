class Snippet {
   public static void leave(){
       //remains will usually drop on the floor the hero died on
       // but are capped at 5 floors above the lowest depth reached (even when ascending)
       depth = Math.max(Dungeon.depth, Statistics.deepestFloor - 5);
       branch = Dungeon.branch;
       //daily runs do not interact with remains
       if (Dungeon.daily) {
           depth = branch = -1;
           return;
       }
       item = pickItem(Dungeon.hero);
       heroClass = Dungeon.hero.heroClass;
       Bundle bundle = new Bundle();
       bundle.put(LEVEL, depth);
       bundle.put(BRANCH, branch);
       bundle.put(ITEM, item);
       bundle.put(HERO_CLASS, heroClass);
       try {
           FileUtils.bundleToFile(BONES_FILE, bundle);
       } catch (IOException e) {
           ShatteredPixelDungeon.reportException(e);
       }
   }
}