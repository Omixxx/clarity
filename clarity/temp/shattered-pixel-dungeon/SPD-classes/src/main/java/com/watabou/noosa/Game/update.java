class Snippet {
  protected void update(){
      Game.elapsed = Game.timeScale * Gdx.graphics.getDeltaTime();
      Game.timeTotal += Game.elapsed;
      Game.realTime = TimeUtils.millis();
      inputHandler.processAllEvents();
      Music.INSTANCE.update();
      Sample.INSTANCE.update();
      scene.update();
      Camera.updateAll();
  }
}