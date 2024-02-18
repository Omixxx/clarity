class Snippet {
  public void clear(){
      for (Pixmap bmp : values()) {
          bmp.dispose();
      }
      super.clear();
  }

}