class Snippet {
    public static void burn(int pos){
        Char ch = Actor.findChar(pos);
        if (ch != null && !ch.isImmune(Fire.class)) {
            Buff.affect(ch, Burning.class).reignite(ch);
        }
        Heap heap = Dungeon.level.heaps.get(pos);
        if (heap != null) {
            heap.burn();
        }
        Plant plant = Dungeon.level.plants.get(pos);
        if (plant != null) {
            plant.wither();
        }
    }

}