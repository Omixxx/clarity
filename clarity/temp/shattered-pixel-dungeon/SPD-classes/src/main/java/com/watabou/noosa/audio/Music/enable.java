class Snippet {
    public synchronized void enable(boolean value){
        enabled = value;
        if (isPlaying() && !value) {
            stop();
        } else if (!isPlaying() && value) {
            if (trackList != null) {
                playTracks(trackList, trackChances, shuffle);
            } else if (lastPlayed != null) {
                play(lastPlayed, looping);
            }
        }
    }
}