class Snippet {
   public synchronized Gizmo random(){
       if (length > 0) {
           return members.get(Random.Int(length));
       } else {
           return null;
       }
   }
}