class Snippet {
   public void onBuildFlagMaps(Level l){
       if (volume > 0) {
           for (int i = 0; i < l.length(); i++) {
               l.solid[i] = l.solid[i] || cur[i] > 0;
               l.flamable[i] = l.flamable[i] || cur[i] > 0;
           }
       }
   }

}