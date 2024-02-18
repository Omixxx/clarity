class Snippet {
   public void sacrifice(Char ch){
       int firePos = -1;
       for (int i : PathFinder.NEIGHBOURS9) {
           if (volume > 0 && cur[ch.pos + i] > 0) {
               firePos = ch.pos + i;
               break;
           }
       }
       if (firePos != -1) {
           int exp = 0;
           if (ch instanceof Mob) {
               //same rates as used in wand of corruption, except for swarms
               if (ch instanceof Statue || ch instanceof Mimic) {
                   exp = 1 + Dungeon.depth;
               } else if (ch instanceof Piranha || ch instanceof Bee) {
                   exp = 1 + Dungeon.depth / 2;
               } else if (ch instanceof Wraith) {
                   exp = 1 + Dungeon.depth / 3;
               } else if (ch instanceof Swarm && ((Swarm) ch).EXP == 0) {
                   //give 1 exp for child swarms, instead of 0
                   exp = 1;
               } else if (((Mob) ch).EXP > 0) {
                   exp = 1 + ((Mob) ch).EXP;
               }
               exp *= Random.IntRange(2, 3);
           } else if (ch instanceof Hero) {
               //always enough to activate the reward, if you can somehow get it
               exp = 1_000_000;
               Badges.validateDeathFromSacrifice();
           }
           if (exp > 0) {
               int volumeLeft = cur[firePos] - exp;
               if (volumeLeft > 0) {
                   cur[firePos] -= exp;
                   volume -= exp;
                   bonusSpawns++;
                   CellEmitter.get(firePos).burst(SacrificialParticle.FACTORY, 20);
                   Sample.INSTANCE.play(Assets.Sounds.BURNING);
                   GLog.w(Messages.get(SacrificialFire.class, "worthy"));
               } else {
                   clear(firePos);
                   Notes.remove(Notes.Landmark.SACRIFICIAL_FIRE);
                   for (int i : PathFinder.NEIGHBOURS9) {
                       CellEmitter.get(firePos + i).burst(SacrificialParticle.FACTORY, 20);
                   }
                   Sample.INSTANCE.play(Assets.Sounds.BURNING);
                   Sample.INSTANCE.play(Assets.Sounds.BURNING);
                   Sample.INSTANCE.play(Assets.Sounds.BURNING);
                   GLog.w(Messages.get(SacrificialFire.class, "reward"));
                   if (prize != null) {
                       Dungeon.level.drop(prize, firePos).sprite.drop();
                   } else {
                       Dungeon.level.drop(SacrificeRoom.prize(Dungeon.level), firePos).sprite.drop();
                   }
               }
           } else {
               GLog.w(Messages.get(SacrificialFire.class, "unworthy"));
           }
       }
   }

}