class Snippet {
  public void destroy(){
      super.destroy();
      if (buffer != null)
          buffer.delete();
  }
}