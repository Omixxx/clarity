class Snippet {
   public synchronized int countLiving(){
       int count = 0;
       for (int i = 0; i < length; i++) {
           Gizmo g = members.get(i);
           if (g != null && g.exists && g.alive) {
               count++;
           }
       }
       return count;
   }

}