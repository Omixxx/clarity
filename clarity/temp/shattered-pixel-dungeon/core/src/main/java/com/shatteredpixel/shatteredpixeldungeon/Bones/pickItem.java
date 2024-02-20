class Snippet {
    private static Item pickItem(Hero hero){
        Item item = null;
        //seeded runs don't leave items
        //This is to prevent using specific seeds to transport items to regular runs
        if (!Dungeon.customSeedText.isEmpty()) {
            return null;
        }
        if (Random.Int(3) != 0) {
            switch(Random.Int(7)) {
                case 0:
                    item = hero.belongings.weapon;
                    //if the hero has two weapons (champion), pick the stronger one
                    if (hero.belongings.secondWep != null && (item == null || hero.belongings.secondWep.trueLevel() > item.trueLevel())) {
                        item = hero.belongings.secondWep;
                        break;
                    }
                    break;
                case 1:
                    item = hero.belongings.armor;
                    break;
                case 2:
                    item = hero.belongings.artifact;
                    break;
                case 3:
                    item = hero.belongings.misc;
                    break;
                case 4:
                    item = hero.belongings.ring;
                    break;
                case 5:
                case 6:
                    item = Dungeon.quickslot.randomNonePlaceholder();
                    break;
            }
            if (item == null || !item.bones) {
                return pickItem(hero);
            }
        } else {
            Iterator<Item> iterator = hero.belongings.backpack.iterator();
            Item curItem;
            ArrayList<Item> items = new ArrayList<>();
            while (iterator.hasNext()) {
                curItem = iterator.next();
                if (curItem.bones) {
                    items.add(curItem);
                }
            }
            //if there are few items, there is an increasingly high chance of leaving nothing
            if (Random.Int(3) < items.size()) {
                item = Random.element(items);
                if (item.stackable) {
                    item.quantity(Random.NormalIntRange(1, (item.quantity() + 1) / 2));
                    if (item.quantity() > 3) {
                        item.quantity(3);
                    }
                }
            } else {
                item = null;
            }
        }
        return item;
    }
}