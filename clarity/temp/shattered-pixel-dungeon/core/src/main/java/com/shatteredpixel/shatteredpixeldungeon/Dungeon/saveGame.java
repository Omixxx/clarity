class Snippet {
    public static void saveGame(int save){
        try {
            Bundle bundle = new Bundle();
            bundle.put(INIT_VER, initialVersion);
            bundle.put(VERSION, version = Game.versionCode);
            bundle.put(SEED, seed);
            bundle.put(CUSTOM_SEED, customSeedText);
            bundle.put(DAILY, daily);
            bundle.put(DAILY_REPLAY, dailyReplay);
            bundle.put(CHALLENGES, challenges);
            bundle.put(MOBS_TO_CHAMPION, mobsToChampion);
            bundle.put(HERO, hero);
            bundle.put(DEPTH, depth);
            bundle.put(BRANCH, branch);
            bundle.put(GOLD, gold);
            bundle.put(ENERGY, energy);
            for (int d : droppedItems.keyArray()) {
                bundle.put(Messages.format(DROPPED, d), droppedItems.get(d));
            }
            quickslot.storePlaceholders(bundle);
            Bundle limDrops = new Bundle();
            LimitedDrops.store(limDrops);
            bundle.put(LIMDROPS, limDrops);
            int count = 0;
            int[] ids = new int[chapters.size()];
            for (Integer id : chapters) {
                ids[count++] = id;
            }
            bundle.put(CHAPTERS, ids);
            Bundle quests = new Bundle();
            Ghost.Quest.storeInBundle(quests);
            Wandmaker.Quest.storeInBundle(quests);
            Blacksmith.Quest.storeInBundle(quests);
            Imp.Quest.storeInBundle(quests);
            bundle.put(QUESTS, quests);
            SpecialRoom.storeRoomsInBundle(bundle);
            SecretRoom.storeRoomsInBundle(bundle);
            Statistics.storeInBundle(bundle);
            Notes.storeInBundle(bundle);
            Generator.storeInBundle(bundle);
            int[] bundleArr = new int[generatedLevels.size()];
            for (int i = 0; i < generatedLevels.size(); i++) {
                bundleArr[i] = generatedLevels.get(i);
            }
            bundle.put(GENERATED_LEVELS, bundleArr);
            Scroll.save(bundle);
            Potion.save(bundle);
            Ring.save(bundle);
            Actor.storeNextID(bundle);
            Bundle badges = new Bundle();
            Badges.saveLocal(badges);
            bundle.put(BADGES, badges);
            FileUtils.bundleToFile(GamesInProgress.gameFile(save), bundle);
        } catch (IOException e) {
            GamesInProgress.setUnknown(save);
            ShatteredPixelDungeon.reportException(e);
        }
    }
}