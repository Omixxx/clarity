class Snippet {
      public synchronized Gizmo recycle(Class<? extends Gizmo> c){
          Gizmo g = getFirstAvailable(c);
          if (g != null) {
              return g;
          } else if (c == null) {
              return null;
          } else {
              g = Reflection.newInstance(c);
              if (g != null) {
                  return add(g);
              }
          }
          return null;
      }
}