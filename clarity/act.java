class Snippet {
  public boolean act(){
      boost--;
      if (boost > 0) {
          spend(interval);
      } else {
          detach();
      }
      return true;
  }

}