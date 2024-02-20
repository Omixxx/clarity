class Snippet {
   public static HashSet<Badge> allUnlocked(){
       loadGlobal();
       return new HashSet<>(global);
   }
}