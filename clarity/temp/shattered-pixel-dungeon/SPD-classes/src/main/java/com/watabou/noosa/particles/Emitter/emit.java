class Snippet {
   protected void emit(int index){
       if (target == null) {
           factory.emit(this, index, x + Random.Float(width), y + Random.Float(height));
       } else {
           if (fillTarget) {
               factory.emit(this, index, target.x + Random.Float(target.width), target.y + Random.Float(target.height));
           } else {
               factory.emit(this, index, target.x + x + Random.Float(width), target.y + y + Random.Float(height));
           }
       }
   }
}