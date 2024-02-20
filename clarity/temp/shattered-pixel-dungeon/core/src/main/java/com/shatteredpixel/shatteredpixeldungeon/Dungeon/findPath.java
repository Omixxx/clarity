class Snippet {
            public static PathFinder.Path findPath(Char ch, int to, boolean[] pass, boolean[] vis, boolean chars){
                return PathFinder.find(ch.pos, to, findPassable(ch, pass, vis, chars));
            }
}