class Snippet {
  public void update(){
      if (isFrozen()) {
          return;
      }
      if (on) {
          time += Game.elapsed;
          while (time > interval) {
              time -= interval;
              emit(count++);
              if (quantity > 0 && count >= quantity) {
                  on = false;
                  break;
              }
          }
      } else if (started && autoKill && countLiving() == 0) {
          kill();
      }
      super.update();
  }
}