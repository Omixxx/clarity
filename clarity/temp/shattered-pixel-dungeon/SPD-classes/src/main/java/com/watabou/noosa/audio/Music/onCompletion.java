class Snippet {
   public void onCompletion(com.badlogic.gdx.audio.Music music){
       //don't play the next track if we're currently in the middle of a fade
       if (fadeTotal == -1f) {
           //we do this in a separate thread to avoid graphics hitching while the music is prepared
           if (!DeviceCompat.isDesktop()) {
               new Thread() {
   
                   @Override
                   public void run() {
                       playNextTrack(music);
                   }
               }.start();
           } else {
               //don't use a separate thread on desktop, causes errors and makes no performance difference
               playNextTrack(music);
           }
       }
   }
}