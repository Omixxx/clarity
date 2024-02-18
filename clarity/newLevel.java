class Snippet {
   public static Level newLevel(){
       Dungeon.level = null;
       Actor.clear();
       Level level;
       if (branch == 0) {
           switch(depth) {
               case 1:
               case 2:
               case 3:
               case 4:
                   level = new SewerLevel();
                   break;
               case 5:
                   level = new SewerBossLevel();
                   break;
               case 6:
               case 7:
               case 8:
               case 9:
                   level = new PrisonLevel();
                   break;
               case 10:
                   level = new PrisonBossLevel();
                   break;
               case 11:
               case 12:
               case 13:
               case 14:
                   level = new CavesLevel();
                   break;
               case 15:
                   level = new CavesBossLevel();
                   break;
               case 16:
               case 17:
               case 18:
               case 19:
                   level = new CityLevel();
                   break;
               case 20:
                   level = new CityBossLevel();
                   break;
               case 21:
               case 22:
               case 23:
               case 24:
                   level = new HallsLevel();
                   break;
               case 25:
                   level = new HallsBossLevel();
                   break;
               case 26:
                   level = new LastLevel();
                   break;
               default:
                   level = new DeadEndLevel();
           }
       } else if (branch == 1) {
           switch(depth) {
               case 11:
               case 12:
               case 13:
               case 14:
                   level = new MiningLevel();
                   break;
               default:
                   level = new DeadEndLevel();
           }
       } else {
           level = new DeadEndLevel();
       }
       //dead end levels get cleared, don't count as generated
       if (!(level instanceof DeadEndLevel)) {
           //this assumes that we will never have a depth value outside the range 0 to 999
           // or -500 to 499, etc.
           if (!generatedLevels.contains(depth + 1000 * branch)) {
               generatedLevels.add(depth + 1000 * branch);
           }
           if (depth > Statistics.deepestFloor && branch == 0) {
               Statistics.deepestFloor = depth;
               if (Statistics.qualifiedForNoKilling) {
                   Statistics.completedWithNoKilling = true;
               } else {
                   Statistics.completedWithNoKilling = false;
               }
           }
       }
       Statistics.qualifiedForBossRemainsBadge = false;
       level.create();
       if (branch == 0)
           Statistics.qualifiedForNoKilling = !bossLevel();
       Statistics.qualifiedForBossChallengeBadge = false;
       return level;
   }

}