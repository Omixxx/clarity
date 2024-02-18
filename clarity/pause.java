class Snippet {
   public synchronized void pause(){
       for (Sound sound : ids.values()) {
           sound.pause();
       }
   }

}