class Snippet {
    public static boolean isKeyBound(int keyCode){
        if (keyCode < 0 || (keyCode > 255 && keyCode < 1000)) {
            return false;
        }
        return bindingKey || bindings.containsKey(keyCode) || controllerBindings.containsKey(keyCode) || hardBindings.containsKey(keyCode);
    }

}