class Snippet {
  public int shielding(){
      if (!needsShieldUpdate) {
          return cachedShield;
      }
      cachedShield = 0;
      for (ShieldBuff s : buffs(ShieldBuff.class)) {
          cachedShield += s.shielding();
      }
      needsShieldUpdate = false;
      return cachedShield;
  }

}