class Snippet {
   public boolean isImmune(Class effect){
       HashSet<Class> immunes = new HashSet<>(immunities);
       for (Property p : properties()) {
           immunes.addAll(p.immunities());
       }
       for (Buff b : buffs()) {
           immunes.addAll(b.immunities());
       }
       for (Class c : immunes) {
           if (c.isAssignableFrom(effect)) {
               return true;
           }
       }
       return false;
   }

}