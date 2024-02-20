class Snippet {
  protected void generate(){
      super.generate();
      bitmap(bitmap);
      filter(fModeMin, fModeMax);
      wrap(wModeH, wModeV);
  }
}