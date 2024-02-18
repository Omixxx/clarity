class Snippet {
  public void update(){
      if (elapsed < 0) {
          onComplete();
          kill();
          return;
      }
      elapsed += Game.elapsed;
      //it's better to skip this frame ahead and finish one frame early
      // if doing one more frame would result in lots of overshoot
      if ((interval - elapsed) < Game.elapsed / 2f) {
          elapsed = interval;
      }
      if (elapsed >= interval) {
          updateValues(1);
          onComplete();
          kill();
      } else {
          updateValues(elapsed / interval);
      }
  }

}