class Snippet {
   public Bundle[] getBundleArray(String key){
       try {
           JSONArray array = data.getJSONArray(key);
           int length = array.length();
           Bundle[] result = new Bundle[length];
           for (int i = 0; i < length; i++) {
               result[i] = new Bundle(array.getJSONObject(i));
           }
           return result;
       } catch (JSONException e) {
           Game.reportException(e);
           return null;
       }
   }

}