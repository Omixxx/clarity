class Snippet {
   public float getFloat(String key){
       return (float) data.optDouble(key, 0.0);
   }

}