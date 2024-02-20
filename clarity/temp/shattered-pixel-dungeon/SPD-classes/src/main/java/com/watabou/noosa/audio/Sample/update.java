class Snippet {
  public void update(){
      synchronized (delayedSFX) {
          if (delayedSFX.isEmpty())
              return;
          for (DelayedSoundEffect sfx : delayedSFX.toArray(new DelayedSoundEffect[0])) {
              sfx.delay -= Game.elapsed;
              if (sfx.delay <= 0) {
                  delayedSFX.remove(sfx);
                  play(sfx.id, sfx.leftVol, sfx.rightVol, sfx.pitch);
              }
          }
      }
  }
}