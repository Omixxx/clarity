class Snippet {
   protected boolean affect(int pos){
       Heap heap;
       if (pos == Dungeon.hero.pos && affectHero(Dungeon.hero)) {
           cur[pos] = 0;
           return true;
       } else if ((heap = Dungeon.level.heaps.get(pos)) != null) {
           Item oldItem = heap.peek();
           Item newItem = affectItem(oldItem, pos);
           if (newItem != null) {
               if (newItem == oldItem) {
               } else if (oldItem.quantity() > 1) {
                   oldItem.quantity(oldItem.quantity() - 1);
                   heap.drop(newItem);
               } else {
                   heap.replace(oldItem, newItem);
               }
               heap.sprite.link();
               cur[pos] = 0;
               return true;
           } else {
               int newPlace;
               do {
                   newPlace = pos + PathFinder.NEIGHBOURS8[Random.Int(8)];
               } while (!Dungeon.level.passable[newPlace] && !Dungeon.level.avoid[newPlace]);
               Dungeon.level.drop(heap.pickUp(), newPlace).sprite.drop(pos);
               return false;
           }
       } else {
           return false;
       }
   }

}