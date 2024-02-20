class Snippet {
   public void vibrate(int millis){
       if (ControllerHandler.isControllerConnected()) {
           ControllerHandler.vibrate(millis);
       } else {
           Gdx.input.vibrate(millis);
       }
   }
}