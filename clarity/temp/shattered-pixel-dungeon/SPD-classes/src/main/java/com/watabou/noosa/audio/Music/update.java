class Snippet {
   public synchronized void update(){
       if (fadeTotal > 0f) {
           fadeTime += Game.elapsed;
           if (player != null) {
               player.setVolume(volumeWithFade());
           }
           if (fadeTime >= fadeTotal) {
               fadeTime = fadeTotal = -1f;
               if (onFadeOut != null) {
                   onFadeOut.call();
               }
           }
       }
   }
}