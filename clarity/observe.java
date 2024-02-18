class Snippet {
    public static void observe(int dist){
        if (level == null) {
            return;
        }
        level.updateFieldOfView(hero, level.heroFOV);
        int x = hero.pos % level.width();
        int y = hero.pos / level.width();
        //left, right, top, bottom
        int l = Math.max(0, x - dist);
        int r = Math.min(x + dist, level.width() - 1);
        int t = Math.max(0, y - dist);
        int b = Math.min(y + dist, level.height() - 1);
        int width = r - l + 1;
        int height = b - t + 1;
        int pos = l + t * level.width();
        for (int i = t; i <= b; i++) {
            BArray.or(level.visited, level.heroFOV, pos, width, level.visited);
            pos += level.width();
        }
        GameScene.updateFog(l, t, width, height);
        if (hero.buff(MindVision.class) != null) {
            for (Mob m : level.mobs.toArray(new Mob[0])) {
                BArray.or(level.visited, level.heroFOV, m.pos - 1 - level.width(), 3, level.visited);
                BArray.or(level.visited, level.heroFOV, m.pos - 1, 3, level.visited);
                BArray.or(level.visited, level.heroFOV, m.pos - 1 + level.width(), 3, level.visited);
                //updates adjacent cells too
                GameScene.updateFog(m.pos, 2);
            }
        }
        if (hero.buff(Awareness.class) != null) {
            for (Heap h : level.heaps.valueList()) {
                BArray.or(level.visited, level.heroFOV, h.pos - 1 - level.width(), 3, level.visited);
                BArray.or(level.visited, level.heroFOV, h.pos - 1, 3, level.visited);
                BArray.or(level.visited, level.heroFOV, h.pos - 1 + level.width(), 3, level.visited);
                GameScene.updateFog(h.pos, 2);
            }
        }
        for (TalismanOfForesight.CharAwareness c : hero.buffs(TalismanOfForesight.CharAwareness.class)) {
            Char ch = (Char) Actor.findById(c.charID);
            if (ch == null || !ch.isAlive())
                continue;
            BArray.or(level.visited, level.heroFOV, ch.pos - 1 - level.width(), 3, level.visited);
            BArray.or(level.visited, level.heroFOV, ch.pos - 1, 3, level.visited);
            BArray.or(level.visited, level.heroFOV, ch.pos - 1 + level.width(), 3, level.visited);
            GameScene.updateFog(ch.pos, 2);
        }
        for (TalismanOfForesight.HeapAwareness h : hero.buffs(TalismanOfForesight.HeapAwareness.class)) {
            if (Dungeon.depth != h.depth || Dungeon.branch != h.branch)
                continue;
            BArray.or(level.visited, level.heroFOV, h.pos - 1 - level.width(), 3, level.visited);
            BArray.or(level.visited, level.heroFOV, h.pos - 1, 3, level.visited);
            BArray.or(level.visited, level.heroFOV, h.pos - 1 + level.width(), 3, level.visited);
            GameScene.updateFog(h.pos, 2);
        }
        for (RevealedArea a : hero.buffs(RevealedArea.class)) {
            if (Dungeon.depth != a.depth || Dungeon.branch != a.branch)
                continue;
            BArray.or(level.visited, level.heroFOV, a.pos - 1 - level.width(), 3, level.visited);
            BArray.or(level.visited, level.heroFOV, a.pos - 1, 3, level.visited);
            BArray.or(level.visited, level.heroFOV, a.pos - 1 + level.width(), 3, level.visited);
            GameScene.updateFog(a.pos, 2);
        }
        for (Char ch : Actor.chars()) {
            if (ch instanceof WandOfWarding.Ward || ch instanceof WandOfRegrowth.Lotus || ch instanceof SpiritHawk.HawkAlly) {
                x = ch.pos % level.width();
                y = ch.pos / level.width();
                //left, right, top, bottom
                dist = ch.viewDistance + 1;
                l = Math.max(0, x - dist);
                r = Math.min(x + dist, level.width() - 1);
                t = Math.max(0, y - dist);
                b = Math.min(y + dist, level.height() - 1);
                width = r - l + 1;
                height = b - t + 1;
                pos = l + t * level.width();
                for (int i = t; i <= b; i++) {
                    BArray.or(level.visited, level.heroFOV, pos, width, level.visited);
                    pos += level.width();
                }
                GameScene.updateFog(ch.pos, dist);
            }
        }
        GameScene.afterObserve();
    }

}