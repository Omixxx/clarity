class Snippet {
  public void remove(){
      if (parent != null) {
          parent.remove(this);
      }
  }
}