class Snippet {
    public static void unlock(Badge badge){
        if (!isUnlocked(badge) && Dungeon.customSeedText.isEmpty()) {
            global.add(badge);
            saveNeeded = true;
        }
    }
}