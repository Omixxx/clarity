class Snippet {
   public void flipHorizontal(boolean value){
       if (flipHorizontal != value) {
           flipHorizontal = value;
           updateVertices();
       }
   }
}