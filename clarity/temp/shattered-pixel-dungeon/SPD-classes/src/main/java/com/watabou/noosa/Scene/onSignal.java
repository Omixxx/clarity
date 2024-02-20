class Snippet {
   public boolean onSignal(KeyEvent event){
       if (Game.instance != null && event.pressed) {
           if (KeyBindings.getActionForKey(event) == GameAction.BACK) {
               onBackPressed();
           }
       }
       return false;
   }
}