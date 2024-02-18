class Snippet {
        public synchronized void playTracks(String[] tracks, float[] chances, boolean shuffle){
            if (tracks == null || tracks.length == 0 || tracks.length != chances.length) {
                stop();
                return;
            }
            //iOS cannot play ogg, so we use an mp3 alternative instead
            if (tracks != null && DeviceCompat.isiOS()) {
                for (int i = 0; i < tracks.length; i++) {
                    tracks[i] = tracks[i].replace(".ogg", ".mp3");
                }
            }
            if (isPlaying() && this.trackList != null && tracks.length == trackList.length) {
                //lists are considered the same if they are identical or merely shifted
                // e.g. the regular title theme and the victory theme are considered equivalent
                boolean sameList = false;
                for (int ofs = 0; ofs < tracks.length; ofs++) {
                    sameList = true;
                    for (int j = 0; j < tracks.length; j++) {
                        int i = (j + ofs) % tracks.length;
                        if (!tracks[i].equals(trackList[j]) || chances[i] != trackChances[j]) {
                            sameList = false;
                            break;
                        }
                    }
                    if (sameList)
                        break;
                }
                if (sameList) {
                    player.setVolume(volumeWithFade());
                    return;
                }
            }
            stop();
            lastPlayed = null;
            trackList = tracks;
            trackChances = chances;
            trackQueue.clear();
            for (int i = 0; i < trackList.length; i++) {
                if (Random.Float() < trackChances[i]) {
                    trackQueue.add(trackList[i]);
                }
            }
            this.looping = false;
            this.shuffle = shuffle;
            if (!enabled || trackQueue.isEmpty()) {
                return;
            }
            play(trackQueue.remove(0), trackLooper);
        }

}