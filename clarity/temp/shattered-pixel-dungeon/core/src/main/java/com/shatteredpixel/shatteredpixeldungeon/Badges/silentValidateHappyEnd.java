class Snippet {
   public static void silentValidateHappyEnd(){
       if (!local.contains(Badge.HAPPY_END)) {
           local.add(Badge.HAPPY_END);
       }
       if (!local.contains(Badge.HAPPY_END_REMAINS) && Dungeon.hero.belongings.getItem(RemainsItem.class) != null) {
           local.add(Badge.HAPPY_END_REMAINS);
       }
   }
}