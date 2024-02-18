class Snippet {
    public static Info check(int slot){
        if (slotStates.containsKey(slot)) {
            return slotStates.get(slot);
        } else if (!gameExists(slot)) {
            slotStates.put(slot, null);
            return null;
        } else {
            Info info;
            try {
                Bundle bundle = FileUtils.bundleFromFile(gameFile(slot));
                info = new Info();
                info.slot = slot;
                Dungeon.preview(info, bundle);
                //saves from before v1.4.3 are not supported
                if (info.version < ShatteredPixelDungeon.v1_4_3) {
                    info = null;
                }
            } catch (IOException e) {
                info = null;
            } catch (Exception e) {
                ShatteredPixelDungeon.reportException(e);
                info = null;
            }
            slotStates.put(slot, info);
            return info;
        }
    }

}