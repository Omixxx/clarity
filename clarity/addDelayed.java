class Snippet {
      public static void addDelayed(Actor actor, float delay){
          add(actor, now + Math.max(delay, 0));
      }

}