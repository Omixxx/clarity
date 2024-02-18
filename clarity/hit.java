class Snippet {
          public static boolean hit(Char attacker, Char defender, float accMulti, boolean magic){
              float acuStat = attacker.attackSkill(defender);
              float defStat = defender.defenseSkill(attacker);
              if (defender instanceof Hero && ((Hero) defender).damageInterrupt) {
                  ((Hero) defender).interrupt();
              }
              //invisible chars always hit (for the hero this is surprise attacking)
              if (attacker.invisible > 0 && attacker.canSurpriseAttack()) {
                  acuStat = INFINITE_ACCURACY;
              }
              if (defender.buff(MonkEnergy.MonkAbility.Focus.FocusBuff.class) != null && !magic) {
                  defStat = INFINITE_EVASION;
                  defender.buff(MonkEnergy.MonkAbility.Focus.FocusBuff.class).detach();
                  Buff.affect(defender, MonkEnergy.MonkAbility.Focus.FocusActivation.class, 0);
              }
              //if accuracy or evasion are large enough, treat them as infinite.
              //note that infinite evasion beats infinite accuracy
              if (defStat >= INFINITE_EVASION) {
                  return false;
              } else if (acuStat >= INFINITE_ACCURACY) {
                  return true;
              }
              float acuRoll = Random.Float(acuStat);
              if (attacker.buff(Bless.class) != null)
                  acuRoll *= 1.25f;
              if (attacker.buff(Hex.class) != null)
                  acuRoll *= 0.8f;
              if (attacker.buff(Daze.class) != null)
                  acuRoll *= 0.5f;
              for (ChampionEnemy buff : attacker.buffs(ChampionEnemy.class)) {
                  acuRoll *= buff.evasionAndAccuracyFactor();
              }
              acuRoll *= AscensionChallenge.statModifier(attacker);
              float defRoll = Random.Float(defStat);
              if (defender.buff(Bless.class) != null)
                  defRoll *= 1.25f;
              if (defender.buff(Hex.class) != null)
                  defRoll *= 0.8f;
              if (defender.buff(Daze.class) != null)
                  defRoll *= 0.5f;
              for (ChampionEnemy buff : defender.buffs(ChampionEnemy.class)) {
                  defRoll *= buff.evasionAndAccuracyFactor();
              }
              defRoll *= AscensionChallenge.statModifier(defender);
              return (acuRoll * accMulti) >= defRoll;
          }

}