class Snippet {
   public float resist(Class effect){
       HashSet<Class> resists = new HashSet<>(resistances);
       for (Property p : properties()) {
           resists.addAll(p.resistances());
       }
       for (Buff b : buffs()) {
           resists.addAll(b.resistances());
       }
       float result = 1f;
       for (Class c : resists) {
           if (c.isAssignableFrom(effect)) {
               result *= 0.5f;
           }
       }
       return result * RingOfElements.resist(this, effect);
   }

}