class Snippet {
   public static PointF currentHoverPos(){
       if (lastHoverPos.x == 0 && lastHoverPos.y == 0) {
           lastHoverPos.x = Game.width / 2;
           lastHoverPos.y = Game.height / 2;
       }
       return lastHoverPos.clone();
   }

}