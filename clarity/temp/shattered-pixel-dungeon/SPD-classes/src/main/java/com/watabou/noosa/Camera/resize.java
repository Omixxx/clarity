class Snippet {
     public void resize(int width, int height){
         this.width = width;
         this.height = height;
         screenWidth = (int) (width * zoom);
         screenHeight = (int) (height * zoom);
     }
}