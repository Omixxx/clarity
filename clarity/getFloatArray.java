class Snippet {
   public float[] getFloatArray(String key){
       try {
           JSONArray array = data.getJSONArray(key);
           int length = array.length();
           float[] result = new float[length];
           for (int i = 0; i < length; i++) {
               result[i] = (float) array.optDouble(i, 0.0);
           }
           return result;
       } catch (JSONException e) {
           Game.reportException(e);
           return null;
       }
   }

}