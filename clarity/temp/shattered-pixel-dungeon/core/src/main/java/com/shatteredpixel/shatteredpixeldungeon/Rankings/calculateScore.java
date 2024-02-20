class Snippet {
  public int calculateScore(){
      if (Dungeon.initialVersion > ShatteredPixelDungeon.v1_2_3) {
          Statistics.progressScore = Dungeon.hero.lvl * Statistics.deepestFloor * 65;
          Statistics.progressScore = Math.min(Statistics.progressScore, 50_000);
          if (Statistics.heldItemValue == 0) {
              for (Item i : Dungeon.hero.belongings) {
                  Statistics.heldItemValue += i.value();
                  if (i instanceof CorpseDust && Statistics.deepestFloor >= 10) {
                      // in case player kept the corpse dust, for a necromancer run
                      Statistics.questScores[1] = 2000;
                  }
              }
          }
          Statistics.treasureScore = Statistics.goldCollected + Statistics.heldItemValue;
          Statistics.treasureScore = Math.min(Statistics.treasureScore, 20_000);
          Statistics.exploreScore = 0;
          int scorePerFloor = Statistics.floorsExplored.size * 50;
          for (Boolean b : Statistics.floorsExplored.valueList()) {
              if (b)
                  Statistics.exploreScore += scorePerFloor;
          }
          Statistics.totalBossScore = 0;
          for (int i : Statistics.bossScores) {
              if (i > 0)
                  Statistics.totalBossScore += i;
          }
          Statistics.totalQuestScore = 0;
          for (int i : Statistics.questScores) {
              if (i > 0)
                  Statistics.totalQuestScore += i;
          }
          Statistics.winMultiplier = 1f;
          if (Statistics.gameWon)
              Statistics.winMultiplier += 1f;
          if (Statistics.ascended)
              Statistics.winMultiplier += 0.5f;
          //pre v1.3.0 runs have different score calculations
          //only progress and treasure score, and they are each up to 50% bigger
          //win multiplier is a simple 2x if run was a win, challenge multi is the same as 1.3.0
      } else {
          Statistics.progressScore = Dungeon.hero.lvl * Statistics.deepestFloor * 100;
          Statistics.treasureScore = Math.min(Statistics.goldCollected, 30_000);
          Statistics.exploreScore = Statistics.totalBossScore = Statistics.totalQuestScore = 0;
          Statistics.winMultiplier = Statistics.gameWon ? 2 : 1;
      }
      Statistics.chalMultiplier = (float) Math.pow(1.25, Challenges.activeChallenges());
      Statistics.chalMultiplier = Math.round(Statistics.chalMultiplier * 20f) / 20f;
      Statistics.totalScore = Statistics.progressScore + Statistics.treasureScore + Statistics.exploreScore + Statistics.totalBossScore + Statistics.totalQuestScore;
      Statistics.totalScore *= Statistics.winMultiplier * Statistics.chalMultiplier;
      return Statistics.totalScore;
  }
}