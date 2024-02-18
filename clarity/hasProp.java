class Snippet {
      public static boolean hasProp(Char ch, Property p){
          return (ch != null && ch.properties().contains(p));
      }

}