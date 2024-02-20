class Snippet {
  public void destroy(){
      super.destroy();
      GameScene.endActorThread();
  }
}