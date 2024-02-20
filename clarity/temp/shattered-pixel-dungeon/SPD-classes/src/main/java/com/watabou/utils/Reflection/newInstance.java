class Snippet {
    public static T newInstance(Class<T> cls){
        try {
            return ClassReflection.newInstance(cls);
        } catch (Exception e) {
            Game.reportException(e);
            return null;
        }
    }
}