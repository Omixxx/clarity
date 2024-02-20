class Snippet {
     public void setSlot(int slot, Item item){
         //we don't want to allow the same item in multiple slots.
         clearItem(item);
         slots[slot] = item;
     }
}