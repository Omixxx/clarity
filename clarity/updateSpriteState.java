class Snippet {
   public synchronized void updateSpriteState(){
       for (Buff buff : buffs) {
           buff.fx(true);
       }
   }

}