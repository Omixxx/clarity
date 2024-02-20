class Snippet {
   protected synchronized void updateVertices(){
       width = 0;
       height = 0;
       if (text == null) {
           text = "";
       }
       quads = Quad.createSet(text.length());
       realLength = 0;
       int length = text.length();
       for (int i = 0; i < length; i++) {
           RectF rect = font.get(text.charAt(i));
           if (rect == null) {
               rect = null;
           }
           float w = font.width(rect);
           float h = font.height(rect);
           vertices[0] = width;
           vertices[1] = 0;
           vertices[2] = rect.left;
           vertices[3] = rect.top;
           vertices[4] = width + w;
           vertices[5] = 0;
           vertices[6] = rect.right;
           vertices[7] = rect.top;
           vertices[8] = width + w;
           vertices[9] = h;
           vertices[10] = rect.right;
           vertices[11] = rect.bottom;
           vertices[12] = width;
           vertices[13] = h;
           vertices[14] = rect.left;
           vertices[15] = rect.bottom;
           quads.put(vertices);
           realLength++;
           width += w + font.tracking;
           if (h > height) {
               height = h;
           }
       }
       if (length > 0) {
           width -= font.tracking;
       }
       dirty = false;
   }
}