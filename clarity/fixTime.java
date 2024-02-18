class Snippet {
    public static synchronized void fixTime(){
        if (all.isEmpty())
            return;
        float min = Float.MAX_VALUE;
        for (Actor a : all) {
            if (a.time < min) {
                min = a.time;
            }
        }
        //Only pull everything back by whole numbers
        //So that turns always align with a whole number
        min = (int) min;
        for (Actor a : all) {
            a.time -= min;
        }
        if (Dungeon.hero != null && all.contains(Dungeon.hero)) {
            Statistics.duration += min;
        }
        now -= min;
    }

}