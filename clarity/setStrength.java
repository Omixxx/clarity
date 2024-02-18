class Snippet {
     public CorrosiveGas setStrength(int str, Class source){
         if (str > strength) {
             strength = str;
             this.source = source;
         }
         return this;
     }

}