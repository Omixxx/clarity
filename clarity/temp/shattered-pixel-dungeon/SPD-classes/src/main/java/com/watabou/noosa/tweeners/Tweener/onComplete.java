class Snippet {
  protected void onComplete(){
      if (listener != null) {
          listener.onComplete(this);
      }
  }
}