class Snippet {
           public void reset(float x, float y, int color, float size, float lifespan){
               revive();
               this.x = x;
               this.y = y;
               color(color);
               size(this.size = size);
               this.left = this.lifespan = lifespan;
           }
}