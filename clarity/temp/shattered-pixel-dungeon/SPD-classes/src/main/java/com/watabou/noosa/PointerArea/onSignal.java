class Snippet {
   public boolean onSignal(PointerEvent event){
       boolean hit = event != null && target.overlapsScreenPoint((int) event.current.x, (int) event.current.y);
       if (!isActive()) {
           return (hit && blockLevel == ALWAYS_BLOCK);
       }
       if (hit) {
           boolean returnValue = (event.type == PointerEvent.Type.DOWN || event == curEvent);
           if (event.type == PointerEvent.Type.DOWN) {
               if (curEvent == null) {
                   curEvent = event;
               }
               onPointerDown(event);
           } else if (event.type == PointerEvent.Type.UP) {
               onPointerUp(event);
               if (curEvent == event) {
                   curEvent = null;
                   onClick(event);
               }
           } else if (event.type == PointerEvent.Type.HOVER) {
               if (event.handled && hovered) {
                   hovered = false;
                   onHoverEnd(event);
               } else if (!event.handled && !hovered) {
                   hovered = true;
                   onHoverStart(event);
               }
               event.handle();
           }
           return returnValue && blockLevel != NEVER_BLOCK;
       } else {
           if (event == null && curEvent != null) {
               onDrag(curEvent);
           } else if (curEvent != null && event.type == PointerEvent.Type.UP) {
               onPointerUp(event);
               curEvent = null;
           } else if (event != null && event.type == PointerEvent.Type.HOVER && hovered) {
               hovered = false;
               onHoverEnd(event);
           }
           return false;
       }
   }
}