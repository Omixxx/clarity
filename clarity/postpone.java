class Snippet {
   protected void postpone(float time){
       if (this.time < now + time) {
           this.time = now + time;
           //if time is very close to a whole number, round to a whole number to fix errors
           float ex = Math.abs(this.time % 1f);
           if (ex < .001f) {
               this.time = Math.round(this.time);
           }
       }
   }

}