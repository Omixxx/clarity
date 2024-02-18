class Snippet {
     public int attackProc(Char enemy, int damage){
         for (ChampionEnemy buff : buffs(ChampionEnemy.class)) {
             buff.onAttackProc(enemy);
         }
         return damage;
     }

}