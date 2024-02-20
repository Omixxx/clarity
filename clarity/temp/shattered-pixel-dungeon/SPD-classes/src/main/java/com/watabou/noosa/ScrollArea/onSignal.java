class Snippet {
   public boolean onSignal(ScrollEvent event){
       boolean hit = event != null && target.overlapsScreenPoint((int) event.pos.x, (int) event.pos.y);
       if (!isActive()) {
           return (hit && blockLevel == ALWAYS_BLOCK);
       }
       if (hit) {
           onScroll(event);
           return true;
       }
       return false;
   }
}