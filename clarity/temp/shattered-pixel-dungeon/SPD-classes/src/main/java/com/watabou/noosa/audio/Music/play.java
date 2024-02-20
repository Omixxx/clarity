class Snippet {
      public synchronized void play(String assetName, boolean looping){
          //iOS cannot play ogg, so we use an mp3 alternative instead
          if (assetName != null && DeviceCompat.isiOS()) {
              assetName = assetName.replace(".ogg", ".mp3");
          }
          if (isPlaying() && lastPlayed != null && lastPlayed.equals(assetName)) {
              player.setVolume(volumeWithFade());
              return;
          }
          stop();
          lastPlayed = assetName;
          trackList = null;
          this.looping = looping;
          this.shuffle = false;
          if (!enabled || assetName == null) {
              return;
          }
          play(assetName, null);
      }
}