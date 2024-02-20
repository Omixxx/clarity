class Snippet {
    public static synchronized float Float(){
        return generators.peek().nextFloat();
    }
}