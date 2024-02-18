class Snippet {
   protected synchronized void updateAnimation(){
       if (curAnim != null && curAnim.delay > 0 && (curAnim.looped || !finished)) {
           int lastFrame = curFrame;
           frameTimer += Game.elapsed;
           while (frameTimer > curAnim.delay) {
               frameTimer -= curAnim.delay;
               if (curFrame >= curAnim.frames.length - 1) {
                   curFrame = curAnim.frames.length - 1;
                   if (curAnim.looped) {
                       curFrame = 0;
                   }
                   finished = true;
                   if (listener != null) {
                       listener.onComplete(curAnim);
                       // This check can probably be removed
                       if (curAnim == null) {
                           return;
                       }
                   }
               } else {
                   curFrame++;
               }
           }
           if (curFrame != lastFrame) {
               frame(curAnim.frames[curFrame]);
           }
       }
   }

}