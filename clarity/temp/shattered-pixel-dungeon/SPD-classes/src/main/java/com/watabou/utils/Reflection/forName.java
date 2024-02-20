class Snippet {
    public static Class forName(String name){
        try {
            return ClassReflection.forName(name);
        } catch (Exception e) {
            Game.reportException(e);
            return null;
        }
    }
}