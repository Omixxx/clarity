class Snippet {
   public void convertToPlaceholder(Item item){
       if (contains(item)) {
           Item placeholder = item.virtual();
           if (placeholder == null)
               return;
           for (int i = 0; i < SIZE; i++) {
               if (getItem(i) == item)
                   setSlot(i, placeholder);
           }
       }
   }
}