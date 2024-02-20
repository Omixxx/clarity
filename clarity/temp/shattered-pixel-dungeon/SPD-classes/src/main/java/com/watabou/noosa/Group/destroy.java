class Snippet {
   public synchronized void destroy(){
       super.destroy();
       for (int i = 0; i < length; i++) {
           Gizmo g = members.get(i);
           if (g != null) {
               g.destroy();
           }
       }
       if (members != null) {
           members.clear();
           members = null;
       }
       length = 0;
   }
}