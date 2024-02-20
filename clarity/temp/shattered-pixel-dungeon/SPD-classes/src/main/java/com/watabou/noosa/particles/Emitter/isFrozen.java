class Snippet {
  protected boolean isFrozen(){
      return Game.timeTotal > 1 && freezeEmitters;
  }
}