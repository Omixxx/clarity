class Snippet {
         public Component setRect(float x, float y, float width, float height){
             this.x = x;
             this.y = y;
             this.width = width;
             this.height = height;
             layout();
             return this;
         }

}