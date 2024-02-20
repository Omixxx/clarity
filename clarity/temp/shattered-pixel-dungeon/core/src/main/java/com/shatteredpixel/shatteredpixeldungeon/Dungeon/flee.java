class Snippet {
            public static int flee(Char ch, int from, boolean[] pass, boolean[] visible, boolean chars){
                boolean[] passable = findPassable(ch, pass, visible, false, true);
                passable[ch.pos] = true;
                //only consider other chars impassable if our retreat step may collide with them
                if (chars) {
                    for (Char c : Actor.chars()) {
                        if (c.pos == from || Dungeon.level.adjacent(c.pos, ch.pos)) {
                            passable[c.pos] = false;
                        }
                    }
                }
                //chars affected by terror have a shorter lookahead and can't approach the fear source
                boolean canApproachFromPos = ch.buff(Terror.class) == null && ch.buff(Dread.class) == null;
                return PathFinder.getStepBack(ch.pos, from, canApproachFromPos ? 8 : 4, passable, canApproachFromPos);
            }
}