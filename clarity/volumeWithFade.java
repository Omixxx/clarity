class Snippet {
   private synchronized float volumeWithFade(){
       if (fadeTotal > 0f) {
           return Math.max(0, volume * ((fadeTotal - fadeTime) / fadeTotal));
       } else {
           return volume;
       }
   }

}