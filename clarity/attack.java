class Snippet {
         public boolean attack(Char enemy, float dmgMulti, float dmgBonus, float accMulti){
             if (enemy == null)
                 return false;
             boolean visibleFight = Dungeon.level.heroFOV[pos] || Dungeon.level.heroFOV[enemy.pos];
             if (enemy.isInvulnerable(getClass())) {
                 if (visibleFight) {
                     enemy.sprite.showStatus(CharSprite.POSITIVE, Messages.get(this, "invulnerable"));
                     Sample.INSTANCE.play(Assets.Sounds.HIT_PARRY, 1f, Random.Float(0.96f, 1.05f));
                 }
                 return false;
             } else if (hit(this, enemy, accMulti, false)) {
                 int dr = Math.round(enemy.drRoll() * AscensionChallenge.statModifier(enemy));
                 if (this instanceof Hero) {
                     Hero h = (Hero) this;
                     if (h.belongings.attackingWeapon() instanceof MissileWeapon && h.subClass == HeroSubClass.SNIPER && !Dungeon.level.adjacent(h.pos, enemy.pos)) {
                         dr = 0;
                     }
                     if (h.buff(MonkEnergy.MonkAbility.UnarmedAbilityTracker.class) != null) {
                         dr = 0;
                     } else if (h.subClass == HeroSubClass.MONK) {
                         //3 turns with standard attack delay
                         Buff.prolong(h, MonkEnergy.MonkAbility.JustHitTracker.class, 4f);
                     }
                 }
                 //we use a float here briefly so that we don't have to constantly round while
                 // potentially applying various multiplier effects
                 float dmg;
                 Preparation prep = buff(Preparation.class);
                 if (prep != null) {
                     dmg = prep.damageRoll(this);
                     if (this == Dungeon.hero && Dungeon.hero.hasTalent(Talent.BOUNTY_HUNTER)) {
                         Buff.affect(Dungeon.hero, Talent.BountyHunterTracker.class, 0.0f);
                     }
                 } else {
                     dmg = damageRoll();
                 }
                 dmg = Math.round(dmg * dmgMulti);
                 Berserk berserk = buff(Berserk.class);
                 if (berserk != null)
                     dmg = berserk.damageFactor(dmg);
                 if (buff(Fury.class) != null) {
                     dmg *= 1.5f;
                 }
                 for (ChampionEnemy buff : buffs(ChampionEnemy.class)) {
                     dmg *= buff.meleeDamageFactor();
                 }
                 dmg *= AscensionChallenge.statModifier(this);
                 //flat damage bonus is applied after positive multipliers, but before negative ones
                 dmg += dmgBonus;
                 //friendly endure
                 Endure.EndureTracker endure = buff(Endure.EndureTracker.class);
                 if (endure != null)
                     dmg = endure.damageFactor(dmg);
                 //enemy endure
                 endure = enemy.buff(Endure.EndureTracker.class);
                 if (endure != null) {
                     dmg = endure.adjustDamageTaken(dmg);
                 }
                 if (enemy.buff(ScrollOfChallenge.ChallengeArena.class) != null) {
                     dmg *= 0.67f;
                 }
                 if (enemy.buff(MonkEnergy.MonkAbility.Meditate.MeditateResistance.class) != null) {
                     dmg *= 0.2f;
                 }
                 if (buff(Weakness.class) != null) {
                     dmg *= 0.67f;
                 }
                 int effectiveDamage = enemy.defenseProc(this, Math.round(dmg));
                 //do not trigger on-hit logic if defenseProc returned a negative value
                 if (effectiveDamage >= 0) {
                     effectiveDamage = Math.max(effectiveDamage - dr, 0);
                     if (enemy.buff(Viscosity.ViscosityTracker.class) != null) {
                         effectiveDamage = enemy.buff(Viscosity.ViscosityTracker.class).deferDamage(effectiveDamage);
                         enemy.buff(Viscosity.ViscosityTracker.class).detach();
                     }
                     //vulnerable specifically applies after armor reductions
                     if (enemy.buff(Vulnerable.class) != null) {
                         effectiveDamage *= 1.33f;
                     }
                     effectiveDamage = attackProc(enemy, effectiveDamage);
                 }
                 if (visibleFight) {
                     if (effectiveDamage > 0 || !enemy.blockSound(Random.Float(0.96f, 1.05f))) {
                         hitSound(Random.Float(0.87f, 1.15f));
                     }
                 }
                 // If the enemy is already dead, interrupt the attack.
                 // This matters as defence procs can sometimes inflict self-damage, such as armor glyphs.
                 if (!enemy.isAlive()) {
                     return true;
                 }
                 enemy.damage(effectiveDamage, this);
                 if (buff(FireImbue.class) != null)
                     buff(FireImbue.class).proc(enemy);
                 if (buff(FrostImbue.class) != null)
                     buff(FrostImbue.class).proc(enemy);
                 if (enemy.isAlive() && enemy.alignment != alignment && prep != null && prep.canKO(enemy)) {
                     enemy.HP = 0;
                     if (!enemy.isAlive()) {
                         enemy.die(this);
                     } else {
                         //helps with triggering any on-damage effects that need to activate
                         enemy.damage(-1, this);
                         DeathMark.processFearTheReaper(enemy);
                     }
                     if (enemy.sprite != null) {
                         enemy.sprite.showStatus(CharSprite.NEGATIVE, Messages.get(Preparation.class, "assassinated"));
                     }
                 }
                 Talent.CombinedLethalityTriggerTracker combinedLethality = buff(Talent.CombinedLethalityTriggerTracker.class);
                 if (combinedLethality != null) {
                     if (enemy.isAlive() && enemy.alignment != alignment && !Char.hasProp(enemy, Property.BOSS) && !Char.hasProp(enemy, Property.MINIBOSS) && this instanceof Hero && (enemy.HP / (float) enemy.HT) <= 0.4f * ((Hero) this).pointsInTalent(Talent.COMBINED_LETHALITY) / 3f) {
                         enemy.HP = 0;
                         if (!enemy.isAlive()) {
                             enemy.die(this);
                         } else {
                             //helps with triggering any on-damage effects that need to activate
                             enemy.damage(-1, this);
                             DeathMark.processFearTheReaper(enemy);
                         }
                         if (enemy.sprite != null) {
                             enemy.sprite.showStatus(CharSprite.NEGATIVE, Messages.get(Talent.CombinedLethalityTriggerTracker.class, "executed"));
                         }
                     }
                     combinedLethality.detach();
                 }
                 if (enemy.sprite != null) {
                     enemy.sprite.bloodBurstA(sprite.center(), effectiveDamage);
                     enemy.sprite.flash();
                 }
                 if (!enemy.isAlive() && visibleFight) {
                     if (enemy == Dungeon.hero) {
                         if (this == Dungeon.hero) {
                             return true;
                         }
                         if (this instanceof WandOfLivingEarth.EarthGuardian || this instanceof MirrorImage || this instanceof PrismaticImage) {
                             Badges.validateDeathFromFriendlyMagic();
                         }
                         Dungeon.fail(this);
                         GLog.n(Messages.capitalize(Messages.get(Char.class, "kill", name())));
                     } else if (this == Dungeon.hero) {
                         GLog.i(Messages.capitalize(Messages.get(Char.class, "defeat", enemy.name())));
                     }
                 }
                 return true;
             } else {
                 enemy.sprite.showStatus(CharSprite.NEUTRAL, enemy.defenseVerb());
                 if (visibleFight) {
                     //TODO enemy.defenseSound? currently miss plays for monks/crab even when they parry
                     Sample.INSTANCE.play(Assets.Sounds.MISS);
                 }
                 return false;
             }
         }

}