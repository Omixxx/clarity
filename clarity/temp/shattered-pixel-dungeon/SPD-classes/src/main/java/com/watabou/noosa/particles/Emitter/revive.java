class Snippet {
  public void revive(){
      //ensure certain emitter variables default to true
      started = false;
      visible = true;
      fillTarget = true;
      autoKill = true;
      super.revive();
  }
}