class Snippet {
    public static void setFalse(boolean[] toBeFalse){
        if (falseArray == null || falseArray.length < toBeFalse.length)
            falseArray = new boolean[toBeFalse.length];
        System.arraycopy(falseArray, 0, toBeFalse, 0, toBeFalse.length);
    }
}