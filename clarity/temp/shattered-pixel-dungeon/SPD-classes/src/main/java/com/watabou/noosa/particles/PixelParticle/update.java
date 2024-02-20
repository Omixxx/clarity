class Snippet {
  public void update(){
      super.update();
      if ((left -= Game.elapsed) <= 0) {
          kill();
      }
  }
}