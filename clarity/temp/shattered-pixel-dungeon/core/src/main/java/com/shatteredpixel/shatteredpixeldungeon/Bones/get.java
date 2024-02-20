class Snippet {
   public static ArrayList<Item> get(){
       //daily runs do not interact with remains
       if (Dungeon.daily) {
           return null;
       }
       if (depth == -1) {
           try {
               Bundle bundle = FileUtils.bundleFromFile(BONES_FILE);
               depth = bundle.getInt(LEVEL);
               branch = bundle.getInt(BRANCH);
               if (depth > 0) {
                   if (bundle.contains(ITEM)) {
                       item = (Item) bundle.get(ITEM);
                   } else {
                       item = null;
                   }
                   if (bundle.contains(HERO_CLASS)) {
                       heroClass = bundle.getEnum(HERO_CLASS, HeroClass.class);
                   } else {
                       heroClass = null;
                   }
               }
               return get();
           } catch (IOException e) {
               return null;
           }
       } else {
           if (lootAtCurLevel()) {
               Bundle emptyBones = new Bundle();
               emptyBones.put(LEVEL, 0);
               try {
                   FileUtils.bundleToFile(BONES_FILE, emptyBones);
               } catch (IOException e) {
                   ShatteredPixelDungeon.reportException(e);
               }
               depth = 0;
               //challenged or seeded runs don't get items from prior runs
               if (Dungeon.challenges != 0 || !Dungeon.customSeedText.isEmpty()) {
                   item = null;
               }
               //Enforces artifact uniqueness
               if (item instanceof Artifact) {
                   if (Generator.removeArtifact(((Artifact) item).getClass())) {
                       //generates a new artifact of the same type, always +0
                       Artifact artifact = Reflection.newInstance(((Artifact) item).getClass());
                       if (artifact != null) {
                           artifact.cursed = true;
                           artifact.cursedKnown = true;
                       }
                       item = artifact;
                   } else {
                       item = new Gold(item.value());
                   }
               }
               if (item != null) {
                   if (item.isUpgradable() && !(item instanceof MissileWeapon)) {
                       item.cursed = true;
                       item.cursedKnown = true;
                   }
                   if (item.isUpgradable()) {
                       //caps at +3
                       if (item.level() > 3) {
                           item.degrade(item.level() - 3);
                       }
                       //thrown weapons are always IDed, otherwise set unknown
                       item.levelKnown = item instanceof MissileWeapon;
                   }
                   item.reset();
               }
               ArrayList<Item> result = new ArrayList<>();
               if (heroClass != null) {
                   result.add(RemainsItem.get(heroClass));
                   if (Dungeon.bossLevel()) {
                       Statistics.qualifiedForBossRemainsBadge = true;
                   }
               }
               if (item != null) {
                   result.add(item);
               }
               return result.isEmpty() ? null : result;
           } else {
               return null;
           }
       }
   }
}