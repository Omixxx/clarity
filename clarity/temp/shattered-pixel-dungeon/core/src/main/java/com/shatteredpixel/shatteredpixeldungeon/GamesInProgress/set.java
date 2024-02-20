class Snippet {
    public static void set(int slot){
        Info info = new Info();
        info.slot = slot;
        info.depth = Dungeon.depth;
        info.challenges = Dungeon.challenges;
        info.seed = Dungeon.seed;
        info.customSeed = Dungeon.customSeedText;
        info.daily = Dungeon.daily;
        info.dailyReplay = Dungeon.dailyReplay;
        info.level = Dungeon.hero.lvl;
        info.str = Dungeon.hero.STR;
        info.strBonus = Dungeon.hero.STR() - Dungeon.hero.STR;
        info.exp = Dungeon.hero.exp;
        info.hp = Dungeon.hero.HP;
        info.ht = Dungeon.hero.HT;
        info.shld = Dungeon.hero.shielding();
        info.heroClass = Dungeon.hero.heroClass;
        info.subClass = Dungeon.hero.subClass;
        info.armorTier = Dungeon.hero.tier();
        info.goldCollected = Statistics.goldCollected;
        info.maxDepth = Statistics.deepestFloor;
        slotStates.put(slot, info);
    }
}