class Snippet {
   public synchronized boolean isPlaying(){
       return player != null && player.isPlaying();
   }
}