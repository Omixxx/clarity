class Snippet {
       public boolean touchDragged(int screenX, int screenY, int pointer){
           screenX /= (Game.dispWidth / (float) Game.width);
           screenY /= (Game.dispHeight / (float) Game.height);
           return super.touchDragged(screenX, screenY, pointer);
       }
}