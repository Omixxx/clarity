class Snippet {
     public void put(String key, boolean value){
         try {
             data.put(key, value);
         } catch (JSONException e) {
             Game.reportException(e);
         }
     }
}