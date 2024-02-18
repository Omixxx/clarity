class Snippet {
        public static int volumeAt(int cell, Class<? extends Blob> type){
            Blob gas = Dungeon.level.blobs.get(type);
            if (gas == null || gas.volume == 0) {
                return 0;
            } else {
                return gas.cur[cell];
            }
        }

}