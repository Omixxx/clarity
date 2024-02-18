class Snippet {
      public static void updateControllerPointer(PointF pos, boolean sendEvent){
          controllerPointerPos.set(pos);
          if (sendEvent) {
              controllerActive = true;
              PointerEvent.addPointerEvent(new PointerEvent((int) controllerPointerPos.x, (int) controllerPointerPos.y, 10_000, PointerEvent.Type.HOVER, PointerEvent.NONE));
          } else {
              PointerEvent.setHoverPos(pos);
          }
      }

}