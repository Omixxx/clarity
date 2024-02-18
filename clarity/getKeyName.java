class Snippet {
    public static String getKeyName(int keyCode){
        if (ControllerHandler.customButtonName(keyCode) != null) {
            return ControllerHandler.customButtonName(keyCode);
        }
        //custom codes for mouse buttons
        if (keyCode == 1003) {
            return "Mouse 4";
        } else if (keyCode == 1004) {
            return "Mouse 5";
        }
        if (keyCode == Input.Keys.UNKNOWN) {
            return "None";
        } else if (keyCode == Input.Keys.PLUS) {
            return "+";
        } else if (keyCode == Input.Keys.BACKSPACE) {
            return "Backspc";
        } else if (keyCode == Input.Keys.FORWARD_DEL) {
            return "Delete";
        } else {
            return Input.Keys.toString(keyCode);
        }
    }

}