class Snippet {
   public Boolean isNonePlaceholder(int slot){
       return getItem(slot) != null && getItem(slot).quantity() > 0;
   }
}