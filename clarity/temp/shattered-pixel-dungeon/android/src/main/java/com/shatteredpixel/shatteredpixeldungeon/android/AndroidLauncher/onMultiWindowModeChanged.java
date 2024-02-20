class Snippet {
   public void onMultiWindowModeChanged(boolean isInMultiWindowMode){
       super.onMultiWindowModeChanged(isInMultiWindowMode);
       support.updateSystemUI();
   }
}