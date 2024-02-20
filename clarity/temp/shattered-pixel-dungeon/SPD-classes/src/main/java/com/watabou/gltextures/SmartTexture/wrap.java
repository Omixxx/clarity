class Snippet {
     public void wrap(int s, int t){
         wModeH = s;
         wModeV = t;
         if (id != -1)
             super.wrap(wModeH, wModeV);
     }
}