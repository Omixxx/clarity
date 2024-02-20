class Snippet {
    public synchronized void volume(float value){
        volume = value;
        if (player != null) {
            player.setVolume(volumeWithFade());
        }
    }
}