class Snippet {
         public boolean touchCancelled(int screenX, int screenY, int pointer, int button){
             //currently emulating functionality from libGDX 1.11.0, do we keep this?
             //in particular this is probably a more graceful way to handle things like system swipes on iOS
             //whereas previously they generated garbage inputs sometimes
             //which were then fixed in v2.2.2
             return touchUp(screenX, screenY, pointer, button);
         }
}