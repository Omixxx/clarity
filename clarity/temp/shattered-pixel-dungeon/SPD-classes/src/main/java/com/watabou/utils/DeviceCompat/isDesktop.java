class Snippet {
   public static boolean isDesktop(){
       return SharedLibraryLoader.isWindows || SharedLibraryLoader.isMac || SharedLibraryLoader.isLinux;
   }
}