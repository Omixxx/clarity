class Snippet {
   public Class[] getClassArray(String key){
       try {
           JSONArray array = data.getJSONArray(key);
           int length = array.length();
           Class[] result = new Class[length];
           for (int i = 0; i < length; i++) {
               String clName = array.getString(i).replace("class ", "");
               if (aliases.containsKey(clName)) {
                   clName = aliases.get(clName);
               }
               Class cl = Reflection.forName(clName);
               result[i] = cl;
           }
           return result;
       } catch (JSONException e) {
           Game.reportException(e);
           return null;
       }
   }
}