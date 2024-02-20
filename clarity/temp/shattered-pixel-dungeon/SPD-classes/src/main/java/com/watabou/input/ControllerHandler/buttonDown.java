class Snippet {
     public boolean buttonDown(Controller controller, int buttonCode){
         setControllerType(controller);
         controllerActive = true;
         int keyCode = buttonToKey(controller, buttonCode);
         if (keyCode != Input.Keys.UNKNOWN) {
             KeyEvent.addKeyEvent(new KeyEvent(keyCode, true));
             return true;
         }
         return false;
     }
}