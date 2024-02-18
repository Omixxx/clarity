class Snippet {
           public void playDelayed(Object id, float delay, float leftVolume, float rightVolume, float pitch){
               if (delay <= 0) {
                   play(id, leftVolume, rightVolume, pitch);
                   return;
               }
               DelayedSoundEffect sfx = new DelayedSoundEffect();
               sfx.id = id;
               sfx.delay = delay;
               sfx.leftVol = leftVolume;
               sfx.rightVol = rightVolume;
               sfx.pitch = pitch;
               synchronized (delayedSFX) {
                   delayedSFX.add(sfx);
               }
           }

}