class Snippet {
    public static GameAction getActionForKey(KeyEvent event){
        if (bindings.containsKey(event.code)) {
            return bindings.get(event.code);
        } else if (controllerBindings.containsKey(event.code)) {
            return controllerBindings.get(event.code);
        } else if (hardBindings.containsKey(event.code)) {
            return hardBindings.get(event.code);
        }
        return GameAction.NONE;
    }

}