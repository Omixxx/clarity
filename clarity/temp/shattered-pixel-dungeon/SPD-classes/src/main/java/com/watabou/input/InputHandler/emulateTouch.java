class Snippet {
       public void emulateTouch(int id, int button, boolean down){
           PointF hoverPos = PointerEvent.currentHoverPos();
           if (down) {
               multiplexer.touchDown((int) hoverPos.x, (int) hoverPos.y, id, button);
           } else {
               multiplexer.touchUp((int) hoverPos.x, (int) hoverPos.y, id, button);
           }
       }
}