class Snippet {
  public PointF normalize(){
      float l = length();
      x /= l;
      y /= l;
      return this;
  }

}