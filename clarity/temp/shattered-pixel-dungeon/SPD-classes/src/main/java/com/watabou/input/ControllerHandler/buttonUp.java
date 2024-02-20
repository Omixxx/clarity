class Snippet {
     public boolean buttonUp(Controller controller, int buttonCode){
         setControllerType(controller);
         controllerActive = true;
         int keyCode = buttonToKey(controller, buttonCode);
         if (keyCode != Input.Keys.UNKNOWN) {
             KeyEvent.addKeyEvent(new KeyEvent(keyCode, false));
             return true;
         }
         return false;
     }
}