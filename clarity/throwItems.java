class Snippet {
  protected void throwItems(){
      Heap heap = Dungeon.level.heaps.get(pos);
      if (heap != null && heap.type == Heap.Type.HEAP && !(heap.peek() instanceof Tengu.BombAbility.BombItem) && !(heap.peek() instanceof Tengu.ShockerAbility.ShockerItem)) {
          ArrayList<Integer> candidates = new ArrayList<>();
          for (int n : PathFinder.NEIGHBOURS8) {
              if (Dungeon.level.passable[pos + n]) {
                  candidates.add(pos + n);
              }
          }
          if (!candidates.isEmpty()) {
              Dungeon.level.drop(heap.pickUp(), Random.element(candidates)).sprite.drop(pos);
          }
      }
  }

}