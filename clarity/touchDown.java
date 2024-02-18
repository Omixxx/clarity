class Snippet {
          public synchronized boolean touchDown(int screenX, int screenY, int pointer, int button){
              if (screenX < 0 || screenX > Game.width || screenY < 0 || screenY > Game.height) {
                  return true;
              }
              if (pointer != ControllerHandler.CONTROLLER_POINTER_ID) {
                  ControllerHandler.setControllerPointer(false);
                  ControllerHandler.controllerActive = false;
              }
              if (button >= 3 && KeyBindings.isKeyBound(button + 1000)) {
                  KeyEvent.addKeyEvent(new KeyEvent(button + 1000, true));
              } else if (button < 3) {
                  PointerEvent.addPointerEvent(new PointerEvent(screenX, screenY, pointer, PointerEvent.Type.DOWN, button));
              }
              return true;
          }

}