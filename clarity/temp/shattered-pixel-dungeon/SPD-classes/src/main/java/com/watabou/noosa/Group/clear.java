class Snippet {
   public synchronized void clear(){
       if (length == 0)
           return;
       for (int i = 0; i < length; i++) {
           Gizmo g = members.get(i);
           if (g != null) {
               g.parent = null;
           }
       }
       members.clear();
       length = 0;
   }
}