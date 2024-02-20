class Snippet {
   public void saveGameData(Record rec){
       if (Dungeon.hero == null) {
           rec.gameData = null;
           return;
       }
       rec.gameData = new Bundle();
       Belongings belongings = Dungeon.hero.belongings;
       //save the hero and belongings
       ArrayList<Item> allItems = (ArrayList<Item>) belongings.backpack.items.clone();
       //remove items that won't show up in the rankings screen
       for (Item item : belongings.backpack.items.toArray(new Item[0])) {
           if (item instanceof Bag) {
               for (Item bagItem : ((Bag) item).items.toArray(new Item[0])) {
                   if (Dungeon.quickslot.contains(bagItem) && !Dungeon.quickslot.contains(item)) {
                       belongings.backpack.items.add(bagItem);
                   }
               }
           }
           if (!Dungeon.quickslot.contains(item)) {
               belongings.backpack.items.remove(item);
           }
       }
       //remove all buffs (ones tied to equipment will be re-applied)
       for (Buff b : Dungeon.hero.buffs()) {
           Dungeon.hero.remove(b);
       }
       rec.gameData.put(HERO, Dungeon.hero);
       //save stats
       Bundle stats = new Bundle();
       Statistics.storeInBundle(stats);
       rec.gameData.put(STATS, stats);
       //save badges
       Bundle badges = new Bundle();
       Badges.saveLocal(badges);
       rec.gameData.put(BADGES, badges);
       //save handler information
       Bundle handler = new Bundle();
       Scroll.saveSelectively(handler, belongings.backpack.items);
       Potion.saveSelectively(handler, belongings.backpack.items);
       //include potentially worn rings
       if (belongings.misc != null)
           belongings.backpack.items.add(belongings.misc);
       if (belongings.ring != null)
           belongings.backpack.items.add(belongings.ring);
       Ring.saveSelectively(handler, belongings.backpack.items);
       rec.gameData.put(HANDLERS, handler);
       //restore items now that we're done saving
       belongings.backpack.items = allItems;
       //save challenges
       rec.gameData.put(CHALLENGES, Dungeon.challenges);
       rec.gameData.put(GAME_VERSION, Dungeon.initialVersion);
       rec.gameData.put(SEED, Dungeon.seed);
       rec.gameData.put(CUSTOM_SEED, Dungeon.customSeedText);
       rec.gameData.put(DAILY, Dungeon.daily);
       rec.gameData.put(DAILY_REPLAY, Dungeon.dailyReplay);
   }
}