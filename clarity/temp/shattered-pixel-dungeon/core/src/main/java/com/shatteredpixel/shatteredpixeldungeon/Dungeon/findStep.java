class Snippet {
            public static int findStep(Char ch, int to, boolean[] pass, boolean[] visible, boolean chars){
                if (Dungeon.level.adjacent(ch.pos, to)) {
                    return Actor.findChar(to) == null && pass[to] ? to : -1;
                }
                return PathFinder.getStep(ch.pos, to, findPassable(ch, pass, visible, chars));
            }
}