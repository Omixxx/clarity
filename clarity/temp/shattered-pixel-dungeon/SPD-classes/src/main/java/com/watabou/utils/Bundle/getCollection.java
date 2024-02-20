class Snippet {
   public Collection<Bundlable> getCollection(String key){
       ArrayList<Bundlable> list = new ArrayList<>();
       try {
           JSONArray array = data.getJSONArray(key);
           for (int i = 0; i < array.length(); i++) {
               Bundlable O = new Bundle(array.getJSONObject(i)).get();
               if (O != null)
                   list.add(O);
           }
       } catch (JSONException e) {
           Game.reportException(e);
       }
       return list;
   }
}