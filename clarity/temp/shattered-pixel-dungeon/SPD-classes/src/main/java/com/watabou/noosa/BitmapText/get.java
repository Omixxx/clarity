class Snippet {
   public RectF get(char ch){
       if (frames.containsKey(ch)) {
           return super.get(ch);
       } else {
           return super.get('?');
       }
   }
}