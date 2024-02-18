class Snippet {
   public void onWindowFocusChanged(boolean hasFocus){
       super.onWindowFocusChanged(hasFocus);
       support.updateSystemUI();
   }

}