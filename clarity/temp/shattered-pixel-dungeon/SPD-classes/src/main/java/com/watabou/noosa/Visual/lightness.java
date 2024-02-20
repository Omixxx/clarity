class Snippet {
   public void lightness(float value){
       if (value < 0.5f) {
           rm = gm = bm = value * 2f;
           ra = ga = ba = 0;
       } else {
           rm = gm = bm = 2f - value * 2f;
           ra = ga = ba = value * 2f - 1f;
       }
   }
}