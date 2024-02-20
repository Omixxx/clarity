class Snippet {
         public boolean touchDown(int screenX, int screenY, int pointer, int button){
             screenX /= (Game.dispWidth / (float) Game.width);
             screenY /= (Game.dispHeight / (float) Game.height);
             return super.touchDown(screenX, screenY, pointer, button);
         }
}