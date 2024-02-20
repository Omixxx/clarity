class Snippet {
         public boolean touchUp(int screenX, int screenY, int pointer, int button){
             screenX /= (Game.dispWidth / (float) Game.width);
             screenY /= (Game.dispHeight / (float) Game.height);
             return super.touchUp(screenX, screenY, pointer, button);
         }
}