class Snippet {
  public void call(){
      synchronized (INSTANCE) {
          String asset = loadingQueue.poll();
          if (asset != null) {
              try {
                  Sound newSound = Gdx.audio.newSound(Gdx.files.internal(asset));
                  ids.put(asset, newSound);
              } catch (Exception e) {
                  Game.reportException(e);
              }
          }
          if (!loadingQueue.isEmpty()) {
              Game.runOnRenderThread(this);
          }
      }
  }
}