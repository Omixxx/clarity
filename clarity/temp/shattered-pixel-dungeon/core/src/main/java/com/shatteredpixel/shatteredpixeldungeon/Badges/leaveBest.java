class Snippet {
      private static void leaveBest(Collection<Badge> list, Badge... badges){
          for (int i = badges.length - 1; i > 0; i--) {
              if (list.contains(badges[i])) {
                  for (int j = 0; j < i; j++) {
                      list.remove(badges[j]);
                  }
                  break;
              }
          }
      }
}