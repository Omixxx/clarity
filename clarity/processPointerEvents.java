class Snippet {
    public static synchronized void processPointerEvents(){
        //handle any hover events separately first as we may need to add drag events
        boolean hovered = false;
        for (PointerEvent p : pointerEvents) {
            if (p.type == Type.HOVER) {
                lastHoverPos.set(p.current);
                pointerSignal.dispatch(p);
                hovered = true;
            }
        }
        for (PointerEvent p : pointerEvents) {
            if (p.type == Type.HOVER) {
                continue;
            }
            clearKeyboardThisPress = true;
            if (activePointers.containsKey(p.id)) {
                PointerEvent existing = activePointers.get(p.id);
                existing.current = p.current;
                if (existing.type == p.type) {
                    pointerSignal.dispatch(null);
                } else if (p.type == Type.DOWN) {
                    pointerSignal.dispatch(existing);
                } else {
                    activePointers.remove(existing.id);
                    pointerSignal.dispatch(existing.up());
                }
            } else {
                if (p.type == Type.DOWN) {
                    activePointers.put(p.id, p);
                }
                pointerSignal.dispatch(p);
            }
            if (clearKeyboardThisPress) {
                //most press events should clear the keyboard
                Game.platform.setOnscreenKeyboardVisible(false);
            }
        }
        pointerEvents.clear();
        //add drag events for any emulated presses
        if (hovered && activePointers.containsKey(ControllerHandler.CONTROLLER_POINTER_ID)) {
            Game.inputHandler.emulateDrag(ControllerHandler.CONTROLLER_POINTER_ID);
        }
    }

}