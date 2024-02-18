class Snippet {
  public int drRoll(){
      int dr = 0;
      dr += Random.NormalIntRange(0, Barkskin.currentLevel(this));
      return dr;
  }

}