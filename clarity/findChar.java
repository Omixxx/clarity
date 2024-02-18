class Snippet {
     public static synchronized Char findChar(int pos){
         for (Char ch : chars) {
             if (ch.pos == pos)
                 return ch;
         }
         return null;
     }

}