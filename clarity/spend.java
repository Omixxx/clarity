class Snippet {
   protected void spend(float time){
       float timeScale = 1f;
       if (buff(Slow.class) != null) {
           timeScale *= 0.5f;
           //slowed and chilled do not stack
       } else if (buff(Chill.class) != null) {
           timeScale *= buff(Chill.class).speedFactor();
       }
       if (buff(Speed.class) != null) {
           timeScale *= 2.0f;
       }
       super.spend(time / timeScale);
   }

}