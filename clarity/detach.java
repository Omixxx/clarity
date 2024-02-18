class Snippet {
  public void detach(){
      if (!target.isAlive()) {
          SacrificialFire fire = (SacrificialFire) Dungeon.level.blobs.get(SacrificialFire.class);
          if (fire != null) {
              fire.sacrifice(target);
          }
      }
      super.detach();
  }

}