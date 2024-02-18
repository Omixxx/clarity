class Snippet {
          public synchronized boolean touchUp(int screenX, int screenY, int pointer, int button){
              if (button >= 3 && KeyBindings.isKeyBound(button + 1000)) {
                  KeyEvent.addKeyEvent(new KeyEvent(button + 1000, false));
              } else if (button < 3) {
                  PointerEvent.addPointerEvent(new PointerEvent(screenX, screenY, pointer, PointerEvent.Type.UP, button));
              }
              return true;
          }

}