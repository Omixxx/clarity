class Snippet {
   public int[] getIntArray(String key){
       try {
           JSONArray array = data.getJSONArray(key);
           int length = array.length();
           int[] result = new int[length];
           for (int i = 0; i < length; i++) {
               result[i] = array.getInt(i);
           }
           return result;
       } catch (JSONException e) {
           Game.reportException(e);
           return null;
       }
   }
}