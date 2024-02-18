class Snippet {
   public synchronized void resume(){
       for (Sound sound : ids.values()) {
           sound.resume();
       }
   }

}