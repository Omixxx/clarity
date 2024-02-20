class Snippet {
     public void setCenterOffset(float x, float y){
         scroll.x += x - centerOffset.x;
         scroll.y += y - centerOffset.y;
         if (panTarget != null) {
             panTarget.x += x - centerOffset.x;
             panTarget.y += y - centerOffset.y;
         }
         centerOffset.set(x, y);
     }
}