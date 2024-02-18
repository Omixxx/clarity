class Snippet {
      public static float angle(PointF start, PointF end){
          return (float) Math.atan2(end.y - start.y, end.x - start.x);
      }

}