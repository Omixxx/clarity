class Snippet {
     public Component setPos(float x, float y){
         this.x = x;
         this.y = y;
         layout();
         return this;
     }
}