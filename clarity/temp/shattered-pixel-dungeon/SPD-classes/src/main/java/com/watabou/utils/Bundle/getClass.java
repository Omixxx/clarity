class Snippet {
   public Class getClass(String key){
       String clName = getString(key).replace("class ", "");
       if (!clName.equals("")) {
           if (aliases.containsKey(clName)) {
               clName = aliases.get(clName);
           }
           return Reflection.forName(clName);
       }
       return null;
   }
}