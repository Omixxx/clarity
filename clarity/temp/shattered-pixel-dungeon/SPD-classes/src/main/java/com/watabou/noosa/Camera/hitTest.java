class Snippet {
     public boolean hitTest(float x, float y){
         return x >= this.x && y >= this.y && x < this.x + screenWidth && y < this.y + screenHeight;
     }
}