class Snippet {
  public PointerEvent up(){
      if (type == Type.DOWN)
          type = Type.UP;
      return this;
  }
}