class Snippet {
     public void filter(int minMode, int maxMode){
         fModeMin = minMode;
         fModeMax = maxMode;
         if (id != -1)
             super.filter(fModeMin, fModeMax);
     }
}