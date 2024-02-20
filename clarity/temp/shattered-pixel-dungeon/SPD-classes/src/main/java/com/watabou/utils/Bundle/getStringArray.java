class Snippet {
   public String[] getStringArray(String key){
       try {
           JSONArray array = data.getJSONArray(key);
           int length = array.length();
           String[] result = new String[length];
           for (int i = 0; i < length; i++) {
               result[i] = array.getString(i);
           }
           return result;
       } catch (JSONException e) {
           Game.reportException(e);
           return null;
       }
   }
}