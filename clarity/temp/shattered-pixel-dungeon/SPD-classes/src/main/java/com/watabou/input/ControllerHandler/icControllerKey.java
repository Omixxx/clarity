class Snippet {
    public static boolean icControllerKey(int keyCode){
        if (keyCode >= Input.Keys.BUTTON_A && keyCode <= Input.Keys.BUTTON_MODE) {
            return true;
        }
        if (keyCode >= Input.Keys.DPAD_UP + DPAD_KEY_OFFSET && keyCode <= Input.Keys.DPAD_RIGHT + DPAD_KEY_OFFSET) {
            return true;
        }
        return false;
    }
}