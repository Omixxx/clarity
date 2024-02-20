class Snippet {
    public static Pixmap getBitmap(Object src){
        try {
            if (src instanceof Integer) {
                //libGDX does not support android resource integer handles, and they were
                //never used by the game anyway, should probably remove this entirely
                return null;
            } else if (src instanceof String) {
                return new Pixmap(Gdx.files.internal((String) src));
            } else if (src instanceof Pixmap) {
                return (Pixmap) src;
            } else {
                return null;
            }
        } catch (Exception e) {
            Game.reportException(e);
            return null;
        }
    }
}