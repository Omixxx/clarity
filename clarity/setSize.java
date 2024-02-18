class Snippet {
     public Component setSize(float width, float height){
         this.width = width;
         this.height = height;
         layout();
         return this;
     }

}