class Snippet {
    public static boolean isChallenged(int mask){
        return (challenges & mask) != 0;
    }
}