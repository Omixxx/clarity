class Snippet {
   public synchronized void stop(){
       if (player != null) {
           player.dispose();
           player = null;
       }
   }
}