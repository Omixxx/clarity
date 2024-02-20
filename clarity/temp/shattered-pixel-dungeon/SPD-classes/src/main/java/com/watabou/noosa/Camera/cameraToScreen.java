class Snippet {
     public Point cameraToScreen(float x, float y){
         return new Point((int) ((x - scroll.x) * zoom + this.x), (int) ((y - scroll.y) * zoom + this.y));
     }
}