class Snippet {
   public void clearItem(Item item){
       if (contains(item)) {
           clearSlot(getSlot(item));
       }
   }
}