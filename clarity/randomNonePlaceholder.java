class Snippet {
  public Item randomNonePlaceholder(){
      ArrayList<Item> result = new ArrayList<>();
      for (int i = 0; i < SIZE; i++) {
          if (getItem(i) != null && !isPlaceholder(i)) {
              result.add(getItem(i));
          }
      }
      return Random.element(result);
  }

}