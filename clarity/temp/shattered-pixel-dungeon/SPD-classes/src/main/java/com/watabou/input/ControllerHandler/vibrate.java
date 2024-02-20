class Snippet {
    public static void vibrate(int millis){
        if (vibrationSupported()) {
            Controllers.getCurrent().startVibration(millis, 1f);
        }
    }
}