class Snippet {
   public static void loadGlobal(){
       if (global == null) {
           try {
               Bundle bundle = FileUtils.bundleFromFile(BADGES_FILE);
               global = restore(bundle);
           } catch (IOException e) {
               global = new HashSet<>();
           }
       }
   }
}