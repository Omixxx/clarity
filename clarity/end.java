class Snippet {
   public synchronized void end(){
       lastPlayed = null;
       trackList = null;
       stop();
   }

}