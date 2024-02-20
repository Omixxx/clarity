class Snippet {
   public void restorePlaceholders(Bundle bundle){
       Collection<Bundlable> placeholders = bundle.getCollection(PLACEHOLDERS);
       boolean[] placements = bundle.getBooleanArray(PLACEMENTS);
       int i = 0;
       for (Bundlable item : placeholders) {
           while (!placements[i]) {
               i++;
           }
           setSlot(i, (Item) item);
           i++;
       }
   }
}