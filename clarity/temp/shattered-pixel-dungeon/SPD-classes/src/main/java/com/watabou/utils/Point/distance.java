class Snippet {
      public static float distance(Point a, Point b){
          float dx = a.x - b.x;
          float dy = a.y - b.y;
          return (float) Math.sqrt(dx * dx + dy * dy);
      }
}