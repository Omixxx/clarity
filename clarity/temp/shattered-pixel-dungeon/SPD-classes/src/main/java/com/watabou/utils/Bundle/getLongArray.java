class Snippet {
   public long[] getLongArray(String key){
       try {
           JSONArray array = data.getJSONArray(key);
           int length = array.length();
           long[] result = new long[length];
           for (int i = 0; i < length; i++) {
               result[i] = array.getLong(i);
           }
           return result;
       } catch (JSONException e) {
           Game.reportException(e);
           return null;
       }
   }
}