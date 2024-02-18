class Snippet {
            public static boolean[] findPassable(Char ch, boolean[] pass, boolean[] vis, boolean chars, boolean considerLarge){
                setupPassable();
                if (ch.flying || ch.buff(Amok.class) != null) {
                    BArray.or(pass, Dungeon.level.avoid, passable);
                } else {
                    System.arraycopy(pass, 0, passable, 0, Dungeon.level.length());
                }
                if (considerLarge && Char.hasProp(ch, Char.Property.LARGE)) {
                    BArray.and(passable, Dungeon.level.openSpace, passable);
                }
                ch.modifyPassable(passable);
                if (chars) {
                    for (Char c : Actor.chars()) {
                        if (vis[c.pos]) {
                            passable[c.pos] = false;
                        }
                    }
                }
                return passable;
            }

}