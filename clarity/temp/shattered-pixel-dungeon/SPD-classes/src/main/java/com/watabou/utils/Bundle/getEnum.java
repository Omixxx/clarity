class Snippet {
     public E getEnum(String key, Class<E> enumClass){
         try {
             return Enum.valueOf(enumClass, data.getString(key));
         } catch (JSONException e) {
             Game.reportException(e);
             return enumClass.getEnumConstants()[0];
         } catch (IllegalArgumentException e) {
             Game.reportException(e);
             return enumClass.getEnumConstants()[0];
         }
     }
}