class Snippet {
  public String desc(){
      if (win) {
          if (ascending) {
              return Messages.get(this, "ascended");
          } else {
              return Messages.get(this, "won");
          }
      } else if (cause == null) {
          return Messages.get(this, "something");
      } else {
          String result = Messages.get(cause, "rankings_desc", (Messages.get(cause, "name")));
          if (result.contains(Messages.NO_TEXT_FOUND)) {
              return Messages.get(this, "something");
          } else {
              return result;
          }
      }
  }
}