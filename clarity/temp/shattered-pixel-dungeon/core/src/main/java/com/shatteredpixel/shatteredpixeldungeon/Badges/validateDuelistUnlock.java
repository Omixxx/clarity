class Snippet {
   public static void validateDuelistUnlock(){
       if (!isUnlocked(Badge.UNLOCK_DUELIST) && Dungeon.hero != null && Dungeon.hero.belongings.weapon instanceof MeleeWeapon && ((MeleeWeapon) Dungeon.hero.belongings.weapon).tier >= 2 && ((MeleeWeapon) Dungeon.hero.belongings.weapon).STRReq() <= Dungeon.hero.STR()) {
           if (Dungeon.hero.belongings.weapon.isIdentified() && ((MeleeWeapon) Dungeon.hero.belongings.weapon).STRReq() <= Dungeon.hero.STR()) {
               displayBadge(Badge.UNLOCK_DUELIST);
           } else if (!Dungeon.hero.belongings.weapon.isIdentified() && ((MeleeWeapon) Dungeon.hero.belongings.weapon).STRReq(0) <= Dungeon.hero.STR()) {
               displayBadge(Badge.UNLOCK_DUELIST);
           }
       }
   }
}