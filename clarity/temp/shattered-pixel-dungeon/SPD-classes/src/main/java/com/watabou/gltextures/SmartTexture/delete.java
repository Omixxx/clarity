class Snippet {
  public void delete(){
      super.delete();
      if (bitmap != null)
          bitmap.dispose();
      bitmap = null;
  }
}