class Snippet {
  public void create(){
      KeyEvent.addKeyListener(keyListener = new Signal.Listener<KeyEvent>() {
  
          @Override
          public boolean onSignal(KeyEvent event) {
              if (Game.instance != null && event.pressed) {
                  if (KeyBindings.getActionForKey(event) == GameAction.BACK) {
                      onBackPressed();
                  }
              }
              return false;
          }
      });
  }
}