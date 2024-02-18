class Snippet {
     public boolean mouseMoved(int screenX, int screenY){
         if (ControllerHandler.controllerPointerActive()) {
             ControllerHandler.setControllerPointer(false);
             PointF hover = ControllerHandler.getControllerPointerPos();
             screenX = (int) hover.x;
             screenY = (int) hover.y;
         }
         PointerEvent.addPointerEvent(new PointerEvent(screenX, screenY, -1, PointerEvent.Type.HOVER));
         return true;
     }

}