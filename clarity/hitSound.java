class Snippet {
   public void hitSound(float pitch){
       Sample.INSTANCE.play(Assets.Sounds.HIT, 1, pitch);
   }

}