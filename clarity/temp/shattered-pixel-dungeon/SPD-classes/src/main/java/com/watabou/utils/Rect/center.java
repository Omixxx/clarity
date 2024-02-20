class Snippet {
  public Point center(){
      return new Point((left + right) / 2 + (((right - left) % 2) == 0 ? Random.Int(2) : 0), (top + bottom) / 2 + (((bottom - top) % 2) == 0 ? Random.Int(2) : 0));
  }
}