class Snippet {
  public HashSet<Property> properties(){
      HashSet<Property> props = new HashSet<>(properties);
      //TODO any more of these and we should make it a property of the buff, like with resistances/immunities
      if (buff(ChampionEnemy.Giant.class) != null) {
          props.add(Property.LARGE);
      }
      return props;
  }

}