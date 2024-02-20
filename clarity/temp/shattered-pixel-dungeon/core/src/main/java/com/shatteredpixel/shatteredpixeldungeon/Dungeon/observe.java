class Snippet {
   public static void observe(){
       int dist = Math.max(Dungeon.hero.viewDistance, 8);
       dist *= 1f + 0.25f * Dungeon.hero.pointsInTalent(Talent.FARSIGHT);
       if (Dungeon.hero.buff(MagicalSight.class) != null) {
           dist = Math.max(dist, MagicalSight.DISTANCE);
       }
       observe(dist + 1);
   }
}