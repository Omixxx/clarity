class Snippet {
   public synchronized void reset(){
       for (Sound sound : ids.values()) {
           sound.dispose();
       }
       ids.clear();
       delayedSFX.clear();
   }
}