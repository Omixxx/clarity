class Snippet {
      public static void addAlias(Class<?> cl, String alias){
          aliases.put(alias, cl.getName());
      }
}