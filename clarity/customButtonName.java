class Snippet {
    public static String customButtonName(int keyCode){
        if (lastUsedType == ControllerType.PLAYSTATION) {
            if (keyCode == Input.Keys.BUTTON_A) {
                return "Cross Button";
            } else if (keyCode == Input.Keys.BUTTON_B) {
                return "Circle Button";
            } else if (keyCode == Input.Keys.BUTTON_X) {
                return "Square Button";
            } else if (keyCode == Input.Keys.BUTTON_Y) {
                return "Triangle Button";
            }
        } else if (lastUsedType == ControllerType.XBOX) {
            if (keyCode == Input.Keys.BUTTON_L1) {
                return "Left Bumper";
            } else if (keyCode == Input.Keys.BUTTON_L2) {
                return "Left Trigger";
            } else if (keyCode == Input.Keys.BUTTON_R1) {
                return "Right Bumper";
            } else if (keyCode == Input.Keys.BUTTON_R2) {
                return "Right Trigger";
            }
        }
        if (keyCode == Input.Keys.DPAD_UP + DPAD_KEY_OFFSET) {
            return Input.Keys.toString(Input.Keys.DPAD_UP);
        } else if (keyCode == Input.Keys.DPAD_DOWN + DPAD_KEY_OFFSET) {
            return Input.Keys.toString(Input.Keys.DPAD_DOWN);
        } else if (keyCode == Input.Keys.DPAD_LEFT + DPAD_KEY_OFFSET) {
            return Input.Keys.toString(Input.Keys.DPAD_LEFT);
        } else if (keyCode == Input.Keys.DPAD_RIGHT + DPAD_KEY_OFFSET) {
            return Input.Keys.toString(Input.Keys.DPAD_RIGHT);
        }
        return null;
    }

}