class Snippet {
     public int defenseProc(Char enemy, int damage){
         Earthroot.Armor armor = buff(Earthroot.Armor.class);
         if (armor != null) {
             damage = armor.absorb(damage);
         }
         return damage;
     }

}