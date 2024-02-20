class Snippet {
   public void flipVertical(boolean value){
       if (flipVertical != value) {
           flipVertical = value;
           updateVertices();
       }
   }
}