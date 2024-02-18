class Snippet {
    public static void dropToChasm(Item item){
        int depth = Dungeon.depth + 1;
        ArrayList<Item> dropped = Dungeon.droppedItems.get(depth);
        if (dropped == null) {
            Dungeon.droppedItems.put(depth, dropped = new ArrayList<>());
        }
        dropped.add(item);
    }

}