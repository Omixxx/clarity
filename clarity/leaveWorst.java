class Snippet {
      private static void leaveWorst(Collection<Badge> list, Badge... badges){
          for (int i = 0; i < badges.length; i++) {
              if (list.contains(badges[i])) {
                  for (int j = i + 1; j < badges.length; j++) {
                      list.remove(badges[j]);
                  }
                  break;
              }
          }
      }

}