class Snippet {
   public synchronized int countDead(){
       int count = 0;
       for (int i = 0; i < length; i++) {
           Gizmo g = members.get(i);
           if (g != null && !g.alive) {
               count++;
           }
       }
       return count;
   }
}