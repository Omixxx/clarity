class Snippet {
     public static synchronized T use(Class<T> c){
         if (c != curScriptClass) {
             Script script = all.get(c);
             if (script == null) {
                 script = Reflection.newInstance(c);
                 all.put(c, script);
             }
             curScript = script;
             curScriptClass = c;
             curScript.use();
         }
         return (T) curScript;
     }
}