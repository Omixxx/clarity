class Snippet {
   public void die(Object src){
       destroy();
       if (src != Chasm.class)
           sprite.die();
   }

}