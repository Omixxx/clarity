class Snippet {
   public synchronized void measure(){
       width = 0;
       height = 0;
       if (text == null) {
           text = "";
       }
       int length = text.length();
       for (int i = 0; i < length; i++) {
           RectF rect = font.get(text.charAt(i));
           float w = font.width(rect);
           float h = font.height(rect);
           width += w + font.tracking;
           if (h > height) {
               height = h;
           }
       }
       if (length > 0) {
           width -= font.tracking;
       }
   }
}