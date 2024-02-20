class Snippet {
  public boolean isVisible(){
      Camera c = camera();
      if (c == null || !visible)
          return false;
      //FIXME, the below calculations ignore angle, so assume visible if angle != 0
      if (angle != 0)
          return true;
      //x coord
      if (x > c.scroll.x + c.width)
          return false;
      else if (!(x >= c.scroll.x || x + width() >= c.scroll.x))
          return false;
      //y coord
      if (y > c.scroll.y + c.height)
          return false;
      else if (!(y >= c.scroll.y || y + height() >= c.scroll.y))
          return false;
      return true;
  }
}