class Snippet {
   public Boolean isPlaceholder(int slot){
       return getItem(slot) != null && getItem(slot).quantity() == 0;
   }
}