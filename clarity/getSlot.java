class Snippet {
   public int getSlot(Item item){
       for (int i = 0; i < SIZE; i++) {
           if (getItem(i) == item) {
               return i;
           }
       }
       return -1;
   }

}