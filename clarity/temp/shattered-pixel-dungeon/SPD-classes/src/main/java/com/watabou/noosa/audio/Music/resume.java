class Snippet {
   public synchronized void resume(){
       if (player != null) {
           player.play();
           player.setLooping(looping);
       }
   }
}