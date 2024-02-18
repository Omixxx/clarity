class Snippet {
  public boolean isActive(){
      if (parent == null) {
          return active;
      } else {
          return active && parent.isActive();
      }
  }

}