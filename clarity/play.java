class Snippet {
          public synchronized long play(Object id, float leftVolume, float rightVolume, float pitch){
              float volume = Math.max(leftVolume, rightVolume);
              float pan = rightVolume - leftVolume;
              if (enabled && ids.containsKey(id)) {
                  return ids.get(id).play(globalVolume * volume, pitch, pan);
              } else {
                  return -1;
              }
          }

}