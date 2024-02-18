class Snippet {
    public static boolean isItemBlocked(Item item){
        if (Dungeon.isChallenged(NO_HERBALISM) && item instanceof Dewdrop) {
            return true;
        }
        return false;
    }

}