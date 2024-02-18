class Snippet {
    public static long Long(long max){
        long result = Long();
        if (result < 0)
            result += Long.MAX_VALUE;
        return result % max;
    }

}