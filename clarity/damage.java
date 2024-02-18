class Snippet {
     public void damage(int dmg, Object src){
         if (!isAlive() || dmg < 0) {
             return;
         }
         if (isInvulnerable(src.getClass())) {
             sprite.showStatus(CharSprite.POSITIVE, Messages.get(this, "invulnerable"));
             return;
         }
         for (ChampionEnemy buff : buffs(ChampionEnemy.class)) {
             dmg = (int) Math.ceil(dmg * buff.damageTakenFactor());
         }
         if (!(src instanceof LifeLink) && buff(LifeLink.class) != null) {
             HashSet<LifeLink> links = buffs(LifeLink.class);
             for (LifeLink link : links.toArray(new LifeLink[0])) {
                 if (Actor.findById(link.object) == null) {
                     links.remove(link);
                     link.detach();
                 }
             }
             dmg = (int) Math.ceil(dmg / (float) (links.size() + 1));
             for (LifeLink link : links) {
                 Char ch = (Char) Actor.findById(link.object);
                 if (ch != null) {
                     ch.damage(dmg, link);
                     if (!ch.isAlive()) {
                         link.detach();
                     }
                 }
             }
         }
         Terror t = buff(Terror.class);
         if (t != null) {
             t.recover();
         }
         Dread d = buff(Dread.class);
         if (d != null) {
             d.recover();
         }
         Charm c = buff(Charm.class);
         if (c != null) {
             c.recover(src);
         }
         if (this.buff(Frost.class) != null) {
             Buff.detach(this, Frost.class);
         }
         if (this.buff(MagicalSleep.class) != null) {
             Buff.detach(this, MagicalSleep.class);
         }
         if (this.buff(Doom.class) != null && !isImmune(Doom.class)) {
             dmg *= 1.67f;
         }
         if (alignment != Alignment.ALLY && this.buff(DeathMark.DeathMarkTracker.class) != null) {
             dmg *= 1.25f;
         }
         Class<?> srcClass = src.getClass();
         if (isImmune(srcClass)) {
             dmg = 0;
         } else {
             dmg = Math.round(dmg * resist(srcClass));
         }
         //TODO improve this when I have proper damage source logic
         if (AntiMagic.RESISTS.contains(src.getClass()) && buff(ArcaneArmor.class) != null) {
             dmg -= Random.NormalIntRange(0, buff(ArcaneArmor.class).level());
             if (dmg < 0)
                 dmg = 0;
         }
         if (buff(Sickle.HarvestBleedTracker.class) != null) {
             if (isImmune(Bleeding.class)) {
                 sprite.showStatus(CharSprite.POSITIVE, Messages.titleCase(Messages.get(this, "immune")));
                 buff(Sickle.HarvestBleedTracker.class).detach();
                 return;
             }
             Bleeding b = buff(Bleeding.class);
             if (b == null) {
                 b = new Bleeding();
             }
             b.announced = false;
             b.set(dmg * buff(Sickle.HarvestBleedTracker.class).bleedFactor, Sickle.HarvestBleedTracker.class);
             b.attachTo(this);
             sprite.showStatus(CharSprite.WARNING, Messages.titleCase(b.name()) + " " + (int) b.level());
             buff(Sickle.HarvestBleedTracker.class).detach();
             return;
         }
         if (buff(Paralysis.class) != null) {
             buff(Paralysis.class).processDamage(dmg);
         }
         int shielded = dmg;
         //FIXME: when I add proper damage properties, should add an IGNORES_SHIELDS property to use here.
         if (!(src instanceof Hunger)) {
             for (ShieldBuff s : buffs(ShieldBuff.class)) {
                 dmg = s.absorbDamage(dmg);
                 if (dmg == 0)
                     break;
             }
         }
         shielded -= dmg;
         HP -= dmg;
         if (HP > 0 && buff(Grim.GrimTracker.class) != null) {
             float finalChance = buff(Grim.GrimTracker.class).maxChance;
             finalChance *= (float) Math.pow(((HT - HP) / (float) HT), 2);
             if (Random.Float() < finalChance) {
                 int extraDmg = Math.round(HP * resist(Grim.class));
                 dmg += extraDmg;
                 HP -= extraDmg;
                 sprite.emitter().burst(ShadowParticle.UP, 5);
                 if (!isAlive() && buff(Grim.GrimTracker.class).qualifiesForBadge) {
                     Badges.validateGrimWeapon();
                 }
             }
         }
         if (HP < 0 && src instanceof Char && alignment == Alignment.ENEMY) {
             if (((Char) src).buff(Kinetic.KineticTracker.class) != null) {
                 int dmgToAdd = -HP;
                 dmgToAdd -= ((Char) src).buff(Kinetic.KineticTracker.class).conservedDamage;
                 dmgToAdd = Math.round(dmgToAdd * Weapon.Enchantment.genericProcChanceMultiplier((Char) src));
                 if (dmgToAdd > 0) {
                     Buff.affect((Char) src, Kinetic.ConservedDamage.class).setBonus(dmgToAdd);
                 }
                 ((Char) src).buff(Kinetic.KineticTracker.class).detach();
             }
         }
         if (sprite != null) {
             //defaults to normal damage icon if no other ones apply
             int icon = FloatingText.PHYS_DMG;
             if (NO_ARMOR_PHYSICAL_SOURCES.contains(src.getClass()))
                 icon = FloatingText.PHYS_DMG_NO_BLOCK;
             if (AntiMagic.RESISTS.contains(src.getClass()))
                 icon = FloatingText.MAGIC_DMG;
             if (src instanceof Pickaxe)
                 icon = FloatingText.PICK_DMG;
             //special case for sniper when using ranged attacks
             if (src == Dungeon.hero && Dungeon.hero.subClass == HeroSubClass.SNIPER && !Dungeon.level.adjacent(Dungeon.hero.pos, pos) && Dungeon.hero.belongings.attackingWeapon() instanceof MissileWeapon) {
                 icon = FloatingText.PHYS_DMG_NO_BLOCK;
             }
             if (src instanceof Hunger)
                 icon = FloatingText.HUNGER;
             if (src instanceof Burning)
                 icon = FloatingText.BURNING;
             if (src instanceof Chill || src instanceof Frost)
                 icon = FloatingText.FROST;
             if (src instanceof GeyserTrap || src instanceof StormCloud)
                 icon = FloatingText.WATER;
             if (src instanceof Burning)
                 icon = FloatingText.BURNING;
             if (src instanceof Electricity)
                 icon = FloatingText.SHOCKING;
             if (src instanceof Bleeding)
                 icon = FloatingText.BLEEDING;
             if (src instanceof ToxicGas)
                 icon = FloatingText.TOXIC;
             if (src instanceof Corrosion)
                 icon = FloatingText.CORROSION;
             if (src instanceof Poison)
                 icon = FloatingText.POISON;
             if (src instanceof Ooze)
                 icon = FloatingText.OOZE;
             if (src instanceof Viscosity.DeferedDamage)
                 icon = FloatingText.DEFERRED;
             if (src instanceof Corruption)
                 icon = FloatingText.CORRUPTION;
             if (src instanceof AscensionChallenge)
                 icon = FloatingText.AMULET;
             sprite.showStatusWithIcon(CharSprite.NEGATIVE, Integer.toString(dmg + shielded), icon);
         }
         if (HP < 0)
             HP = 0;
         if (!isAlive()) {
             die(src);
         } else if (HP == 0 && buff(DeathMark.DeathMarkTracker.class) != null) {
             DeathMark.processFearTheReaper(this);
         }
     }

}