class Snippet {
  public float iconFadePercent(){
      return Math.max(0, (DURATION - visualcooldown()) / DURATION);
  }

}