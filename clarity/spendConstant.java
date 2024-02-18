class Snippet {
   protected void spendConstant(float time){
       TimekeepersHourglass.timeFreeze freeze = buff(TimekeepersHourglass.timeFreeze.class);
       if (freeze != null) {
           freeze.processTime(time);
           return;
       }
       Swiftthistle.TimeBubble bubble = buff(Swiftthistle.TimeBubble.class);
       if (bubble != null) {
           bubble.processTime(time);
           return;
       }
       super.spendConstant(time);
   }

}