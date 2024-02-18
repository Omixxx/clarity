class Snippet {
  public void onDeath(){
      Badges.validateDeathFromGas();
      Dungeon.fail(this);
      GLog.n(Messages.get(this, "ondeath"));
  }

}