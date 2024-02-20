class Snippet {
     public boolean scrolled(float amountX, float amountY){
         ScrollEvent.addScrollEvent(new ScrollEvent(PointerEvent.currentHoverPos(), amountY));
         return true;
     }
}