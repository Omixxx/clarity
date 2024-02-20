class Snippet {
   public synchronized void updateMap(){
       updated.set(0, 0, mapWidth, mapHeight);
       fullUpdate = true;
   }
}