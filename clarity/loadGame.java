class Snippet {
        public static void loadGame(int save, boolean fullLoad) throws IOException{
            Bundle bundle = FileUtils.bundleFromFile(GamesInProgress.gameFile(save));
            //pre-1.3.0 saves
            if (bundle.contains(INIT_VER)) {
                initialVersion = bundle.getInt(INIT_VER);
            } else {
                initialVersion = bundle.getInt(VERSION);
            }
            version = bundle.getInt(VERSION);
            seed = bundle.contains(SEED) ? bundle.getLong(SEED) : DungeonSeed.randomSeed();
            customSeedText = bundle.getString(CUSTOM_SEED);
            daily = bundle.getBoolean(DAILY);
            dailyReplay = bundle.getBoolean(DAILY_REPLAY);
            Actor.clear();
            Actor.restoreNextID(bundle);
            quickslot.reset();
            QuickSlotButton.reset();
            Toolbar.swappedQuickslots = false;
            Dungeon.challenges = bundle.getInt(CHALLENGES);
            Dungeon.mobsToChampion = bundle.getInt(MOBS_TO_CHAMPION);
            Dungeon.level = null;
            Dungeon.depth = -1;
            Scroll.restore(bundle);
            Potion.restore(bundle);
            Ring.restore(bundle);
            quickslot.restorePlaceholders(bundle);
            if (fullLoad) {
                LimitedDrops.restore(bundle.getBundle(LIMDROPS));
                chapters = new HashSet<>();
                int[] ids = bundle.getIntArray(CHAPTERS);
                if (ids != null) {
                    for (int id : ids) {
                        chapters.add(id);
                    }
                }
                Bundle quests = bundle.getBundle(QUESTS);
                if (!quests.isNull()) {
                    Ghost.Quest.restoreFromBundle(quests);
                    Wandmaker.Quest.restoreFromBundle(quests);
                    Blacksmith.Quest.restoreFromBundle(quests);
                    Imp.Quest.restoreFromBundle(quests);
                } else {
                    Ghost.Quest.reset();
                    Wandmaker.Quest.reset();
                    Blacksmith.Quest.reset();
                    Imp.Quest.reset();
                }
                SpecialRoom.restoreRoomsFromBundle(bundle);
                SecretRoom.restoreRoomsFromBundle(bundle);
            }
            Bundle badges = bundle.getBundle(BADGES);
            if (!badges.isNull()) {
                Badges.loadLocal(badges);
            } else {
                Badges.reset();
            }
            Notes.restoreFromBundle(bundle);
            hero = null;
            hero = (Hero) bundle.get(HERO);
            depth = bundle.getInt(DEPTH);
            branch = bundle.getInt(BRANCH);
            gold = bundle.getInt(GOLD);
            energy = bundle.getInt(ENERGY);
            Statistics.restoreFromBundle(bundle);
            Generator.restoreFromBundle(bundle);
            generatedLevels.clear();
            if (bundle.contains(GENERATED_LEVELS)) {
                for (int i : bundle.getIntArray(GENERATED_LEVELS)) {
                    generatedLevels.add(i);
                }
                //pre-v2.1.1 saves
            } else {
                for (int i = 1; i <= Statistics.deepestFloor; i++) {
                    generatedLevels.add(i);
                }
            }
            droppedItems = new SparseArray<>();
            for (int i = 1; i <= 26; i++) {
                //dropped items
                ArrayList<Item> items = new ArrayList<>();
                if (bundle.contains(Messages.format(DROPPED, i)))
                    for (Bundlable b : bundle.getCollection(Messages.format(DROPPED, i))) {
                        items.add((Item) b);
                    }
                if (!items.isEmpty()) {
                    droppedItems.put(i, items);
                }
            }
        }

}