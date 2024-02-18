class Snippet {
   protected synchronized void onRemove(){
       for (Buff buff : buffs.toArray(new Buff[buffs.size()])) {
           buff.detach();
       }
   }

}