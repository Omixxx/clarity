class Snippet {
  public void setupArea(){
      for (int cell = 0; cell < cur.length; cell++) {
          if (cur[cell] != 0) {
              area.union(cell % Dungeon.level.width(), cell / Dungeon.level.width());
          }
      }
  }

}