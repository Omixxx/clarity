class Snippet {
      public synchronized Gizmo getFirstAvailable(Class<? extends Gizmo> c){
          for (int i = 0; i < length; i++) {
              Gizmo g = members.get(i);
              if (g != null && !g.exists && ((c == null) || g.getClass() == c)) {
                  return g;
              }
          }
          return null;
      }

}