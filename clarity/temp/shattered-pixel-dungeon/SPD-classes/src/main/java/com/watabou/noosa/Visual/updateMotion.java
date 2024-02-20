class Snippet {
  protected void updateMotion(){
      if (acc.x != 0)
          speed.x += acc.x * Game.elapsed;
      if (speed.x != 0)
          x += speed.x * Game.elapsed;
      if (acc.y != 0)
          speed.y += acc.y * Game.elapsed;
      if (speed.y != 0)
          y += speed.y * Game.elapsed;
      if (angularSpeed != 0)
          angle += angularSpeed * Game.elapsed;
  }
}