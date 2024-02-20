class Snippet {
  public void destroy(){
      super.destroy();
      ScrollEvent.removeScrollListener(scrollListener);
  }
}