class Snippet {
  public Animation clone(){
      return new Animation(Math.round(1 / delay), looped).frames(frames);
  }

}