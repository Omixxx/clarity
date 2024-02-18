class Snippet {
     public boolean inside(float x, float y){
         return x >= this.x && y >= this.y && x < this.x + width && y < this.y + height;
     }

}