class Snippet {
      public static void delayChar(Char ch, float time){
          ch.spendConstant(time);
          for (Buff b : ch.buffs()) {
              b.spendConstant(time);
          }
      }

}