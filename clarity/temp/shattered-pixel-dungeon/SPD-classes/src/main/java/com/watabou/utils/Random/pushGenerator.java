class Snippet {
    public static synchronized void pushGenerator(){
        generators.push(new java.util.Random());
    }
}