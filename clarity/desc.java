class Snippet {
  public String desc(){
      return Messages.get(this, "desc", boost, dispTurns(visualcooldown()));
  }

}