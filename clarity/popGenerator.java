class Snippet {
    public static synchronized void popGenerator(){
        if (generators.size() == 1) {
            Game.reportException(new RuntimeException("tried to pop the last random number generator!"));
        } else {
            generators.pop();
        }
    }

}