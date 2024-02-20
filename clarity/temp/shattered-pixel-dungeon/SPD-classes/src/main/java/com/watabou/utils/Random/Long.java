class Snippet {
    public static synchronized long Long(){
        return generators.peek().nextLong();
    }
}