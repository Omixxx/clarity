class Snippet {
   public Bundle getBundle(String key){
       return new Bundle(data.optJSONObject(key));
   }

}