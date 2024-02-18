class Snippet {
  public ArrayList<Point> getPoints(){
      ArrayList<Point> points = new ArrayList<>();
      for (int i = left; i <= right; i++) for (int j = top; j <= bottom; j++) points.add(new Point(i, j));
      return points;
  }

}