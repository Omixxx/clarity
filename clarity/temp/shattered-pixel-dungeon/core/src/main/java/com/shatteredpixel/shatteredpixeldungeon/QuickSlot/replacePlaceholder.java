class Snippet {
   public void replacePlaceholder(Item item){
       for (int i = 0; i < SIZE; i++) {
           if (isPlaceholder(i) && item.isSimilar(getItem(i))) {
               setSlot(i, item);
           }
       }
   }
}