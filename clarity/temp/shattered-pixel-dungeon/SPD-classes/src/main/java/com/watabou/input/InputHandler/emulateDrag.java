class Snippet {
   public void emulateDrag(int id){
       PointF hoverPos = PointerEvent.currentHoverPos();
       multiplexer.touchDragged((int) hoverPos.x, (int) hoverPos.y, id);
   }
}