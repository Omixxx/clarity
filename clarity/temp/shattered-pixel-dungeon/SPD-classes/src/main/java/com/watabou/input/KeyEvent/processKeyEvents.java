class Snippet {
    public static synchronized void processKeyEvents(){
        for (KeyEvent k : keyEvents) {
            if (KeyBindings.getActionForKey(k) == GameAction.LEFT_CLICK) {
                Game.inputHandler.emulateTouch(ControllerHandler.CONTROLLER_POINTER_ID, PointerEvent.LEFT, k.pressed);
                if (KeyBindings.bindingKey)
                    keySignal.dispatch(k);
            } else if (KeyBindings.getActionForKey(k) == GameAction.RIGHT_CLICK) {
                Game.inputHandler.emulateTouch(ControllerHandler.CONTROLLER_POINTER_ID, PointerEvent.RIGHT, k.pressed);
                if (KeyBindings.bindingKey)
                    keySignal.dispatch(k);
            } else if (KeyBindings.getActionForKey(k) == GameAction.MIDDLE_CLICK) {
                Game.inputHandler.emulateTouch(ControllerHandler.CONTROLLER_POINTER_ID, PointerEvent.MIDDLE, k.pressed);
                if (KeyBindings.bindingKey)
                    keySignal.dispatch(k);
            } else {
                keySignal.dispatch(k);
            }
        }
        keyEvents.clear();
    }
}