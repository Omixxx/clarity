class Snippet {
   public static void process(){
       boolean doNext;
       boolean interrupted = false;
       do {
           current = null;
           if (!interrupted) {
               float earliest = Float.MAX_VALUE;
               for (Actor actor : all) {
                   //some actors will always go before others if time is equal.
                   if (actor.time < earliest || actor.time == earliest && (current == null || actor.actPriority > current.actPriority)) {
                       earliest = actor.time;
                       current = actor;
                   }
               }
           }
           if (current != null) {
               now = current.time;
               Actor acting = current;
               if (acting instanceof Char && ((Char) acting).sprite != null) {
                   // If it's character's turn to act, but its sprite
                   // is moving, wait till the movement is over
                   try {
                       synchronized (((Char) acting).sprite) {
                           if (((Char) acting).sprite.isMoving) {
                               ((Char) acting).sprite.wait();
                           }
                       }
                   } catch (InterruptedException e) {
                       interrupted = true;
                   }
               }
               interrupted = interrupted || Thread.interrupted();
               if (interrupted) {
                   doNext = false;
                   current = null;
               } else {
                   doNext = acting.act();
                   if (doNext && (Dungeon.hero == null || !Dungeon.hero.isAlive())) {
                       doNext = false;
                       current = null;
                   }
               }
           } else {
               doNext = false;
           }
           if (!doNext) {
               synchronized (Thread.currentThread()) {
                   interrupted = interrupted || Thread.interrupted();
                   if (interrupted) {
                       current = null;
                       interrupted = false;
                   }
                   //signals to the gamescene that actor processing is finished for now
                   Thread.currentThread().notify();
                   try {
                       Thread.currentThread().wait();
                   } catch (InterruptedException e) {
                       interrupted = true;
                   }
               }
           }
       } while (keepActorThreadAlive);
   }

}