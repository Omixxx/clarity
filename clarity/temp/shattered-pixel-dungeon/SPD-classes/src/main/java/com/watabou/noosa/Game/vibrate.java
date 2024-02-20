class Snippet {
    public static void vibrate(int milliseconds){
        if (platform.supportsVibration()) {
            platform.vibrate(milliseconds);
        }
    }
}