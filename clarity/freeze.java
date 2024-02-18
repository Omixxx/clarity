class Snippet {
    public static void freeze(int cell){
        Char ch = Actor.findChar(cell);
        if (ch != null && !ch.isImmune(Freezing.class)) {
            if (ch.buff(Frost.class) != null) {
                Buff.affect(ch, Frost.class, 2f);
            } else {
                Chill chill = ch.buff(Chill.class);
                float turnsToAdd = Dungeon.level.water[cell] ? 5f : 3f;
                if (chill != null) {
                    float chillToCap = Chill.DURATION - chill.cooldown();
                    //account for resistance to chill
                    chillToCap /= ch.resist(Chill.class);
                    turnsToAdd = Math.min(turnsToAdd, chillToCap);
                }
                if (turnsToAdd > 0f) {
                    Buff.affect(ch, Chill.class, turnsToAdd);
                }
                if (chill != null && chill.cooldown() >= Chill.DURATION && !ch.isImmune(Frost.class)) {
                    Buff.affect(ch, Frost.class, Frost.DURATION);
                }
            }
        }
        Heap heap = Dungeon.level.heaps.get(cell);
        if (heap != null)
            heap.freeze();
    }

}