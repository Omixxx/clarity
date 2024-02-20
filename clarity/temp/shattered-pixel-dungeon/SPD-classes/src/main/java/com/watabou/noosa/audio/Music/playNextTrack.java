class Snippet {
    private synchronized void playNextTrack(com.badlogic.gdx.audio.Music music){
        if (trackList == null || trackList.length == 0 || music != player || player.isLooping()) {
            return;
        }
        Music.this.stop();
        if (trackQueue.isEmpty()) {
            for (int i = 0; i < trackList.length; i++) {
                if (Random.Float() < trackChances[i]) {
                    trackQueue.add(trackList[i]);
                }
            }
            if (shuffle)
                Collections.shuffle(trackQueue);
        }
        if (!enabled || trackQueue.isEmpty()) {
            return;
        }
        play(trackQueue.remove(0), trackLooper);
    }
}