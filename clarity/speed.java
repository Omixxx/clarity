class Snippet {
  public float speed(){
      float speed = baseSpeed;
      if (buff(Cripple.class) != null)
          speed /= 2f;
      if (buff(Stamina.class) != null)
          speed *= 1.5f;
      if (buff(Adrenaline.class) != null)
          speed *= 2f;
      if (buff(Haste.class) != null)
          speed *= 3f;
      if (buff(Dread.class) != null)
          speed *= 2f;
      return speed;
  }

}