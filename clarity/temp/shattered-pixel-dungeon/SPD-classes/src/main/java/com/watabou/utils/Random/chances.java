class Snippet {
    public static int chances(float[] chances){
        int length = chances.length;
        float sum = 0;
        for (int i = 0; i < length; i++) {
            sum += chances[i];
        }
        float value = Float(sum);
        sum = 0;
        for (int i = 0; i < length; i++) {
            sum += chances[i];
            if (value < sum) {
                return i;
            }
        }
        return -1;
    }
}