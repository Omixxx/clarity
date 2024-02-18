class Snippet {
     public boolean overlapsPoint(float x, float y){
         return x >= this.x && x < this.x + width * scale.x && y >= this.y && y < this.y + height * scale.y;
     }

}