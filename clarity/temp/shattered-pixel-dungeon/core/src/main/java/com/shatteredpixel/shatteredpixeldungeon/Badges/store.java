class Snippet {
      public static void store(Bundle bundle, HashSet<Badge> badges){
          addReplacedBadges(badges);
          int count = 0;
          String[] names = new String[badges.size()];
          for (Badge badge : badges) {
              names[count++] = badge.name();
          }
          bundle.put(BADGES, names);
      }
}