class Snippet {
    public static synchronized void resetGenerators(){
        generators = new ArrayDeque<>();
        generators.push(new java.util.Random());
    }

}