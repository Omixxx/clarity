class Snippet {
  public boolean isVisible(){
      if (parent == null) {
          return visible;
      } else {
          return visible && parent.isVisible();
      }
  }
}