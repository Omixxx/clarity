class Snippet {
   public void storePlaceholders(Bundle bundle){
       ArrayList<Item> placeholders = new ArrayList<>(SIZE);
       boolean[] placements = new boolean[SIZE];
       for (int i = 0; i < SIZE; i++) {
           if (isPlaceholder(i)) {
               placeholders.add(getItem(i));
               placements[i] = true;
           }
       }
       bundle.put(PLACEHOLDERS, placeholders);
       bundle.put(PLACEMENTS, placements);
   }

}