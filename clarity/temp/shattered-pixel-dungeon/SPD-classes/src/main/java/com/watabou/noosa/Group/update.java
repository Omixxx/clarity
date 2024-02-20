class Snippet {
   public synchronized void update(){
       for (int i = 0; i < length; i++) {
           Gizmo g = members.get(i);
           if (g != null && g.exists && g.active) {
               g.update();
           }
       }
   }
}