class Snippet {
   public boolean[] getBooleanArray(String key){
       try {
           JSONArray array = data.getJSONArray(key);
           int length = array.length();
           boolean[] result = new boolean[length];
           for (int i = 0; i < length; i++) {
               result[i] = array.getBoolean(i);
           }
           return result;
       } catch (JSONException e) {
           Game.reportException(e);
           return null;
       }
   }
}