class Snippet {
    public static void affectCell(int cell){
        Class<?>[] waters = { WaterOfHealth.class, WaterOfAwareness.class };
        for (Class<?> waterClass : waters) {
            WellWater water = (WellWater) Dungeon.level.blobs.get(waterClass);
            if (water != null && water.volume > 0 && water.cur[cell] > 0 && water.affect(cell)) {
                Level.set(cell, Terrain.EMPTY_WELL);
                GameScene.updateMap(cell);
                return;
            }
        }
    }

}