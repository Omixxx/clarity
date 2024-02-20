class Snippet {
   public synchronized void pause(){
       if (player != null) {
           player.pause();
       }
   }
}