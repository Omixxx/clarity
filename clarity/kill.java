class Snippet {
   public synchronized void kill(){
       // A killed group keeps all its members,
       // but they get killed too
       for (int i = 0; i < length; i++) {
           Gizmo g = members.get(i);
           if (g != null && g.exists) {
               g.kill();
           }
       }
       super.kill();
   }

}