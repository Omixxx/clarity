class Snippet {
  protected void evolve(){
      int cell;
      boolean seen = false;
      for (int i = area.top - 1; i <= area.bottom; i++) {
          for (int j = area.left - 1; j <= area.right; j++) {
              cell = j + i * Dungeon.level.width();
              if (Dungeon.level.insideMap(cell)) {
                  off[cell] = cur[cell];
                  volume += off[cell];
                  if (off[cell] > 0 && Dungeon.level.visited[cell]) {
                      seen = true;
                  }
              }
          }
      }
      if (seen) {
          Notes.add(record());
      } else {
          Notes.remove(record());
      }
  }

}