class Snippet {
   private synchronized void moveToUpdating(){
       updating = new Rect(updated);
       updated.setEmpty();
   }

}