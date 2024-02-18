class Snippet {
  public void onMotionComplete(){
      //Does nothing by default
      //The main actor thread already accounts for motion,
      // so calling next() here isn't necessary (see Actor.process)
  }

}