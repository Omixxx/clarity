class Snippet {
     public PointF polar(float a, float l){
         this.x = l * (float) Math.cos(a);
         this.y = l * (float) Math.sin(a);
         return this;
     }
}