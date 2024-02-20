class Snippet {
  public ArrayList<String> getKeys(){
      Iterator<String> keys = data.keys();
      ArrayList<String> result = new ArrayList<>();
      while (keys.hasNext()) {
          result.add(keys.next());
      }
      return result;
  }
}