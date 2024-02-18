class Snippet {
  public void killAndErase(){
      kill();
      if (parent != null) {
          parent.erase(this);
      }
  }

}