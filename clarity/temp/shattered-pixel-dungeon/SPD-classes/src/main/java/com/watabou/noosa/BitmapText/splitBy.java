class Snippet {
         protected void splitBy(Pixmap bitmap, int height, int color, String chars){
             int length = chars.length();
             int width = bitmap.getWidth();
             float vHeight = (float) height / bitmap.getHeight();
             int pos;
             int line = 0;
             spaceMeasuring: for (pos = 0; pos < width; pos++) {
                 for (int j = 0; j < height; j++) {
                     if (bitmap.getPixel(pos, j) != color) {
                         break spaceMeasuring;
                     }
                 }
             }
             add(' ', new RectF(0, 0, (float) pos / width, vHeight - 0.01f));
             int separator = pos;
             for (int i = 0; i < length; i++) {
                 char ch = chars.charAt(i);
                 if (ch == ' ') {
                     continue;
                 } else {
                     boolean found;
                     do {
                         if (separator >= width) {
                             line += height;
                             separator = 0;
                         }
                         found = false;
                         for (int j = line; j < line + height; j++) {
                             if (colorNotMatch(bitmap, separator, j, color)) {
                                 found = true;
                                 break;
                             }
                         }
                         if (!found)
                             separator++;
                     } while (!found);
                     int start = separator;
                     do {
                         if (++separator >= width) {
                             line += height;
                             separator = start = 0;
                             if (line + height >= bitmap.getHeight())
                                 break;
                         }
                         found = true;
                         for (int j = line; j < line + height; j++) {
                             if (colorNotMatch(bitmap, separator, j, color)) {
                                 found = false;
                                 break;
                             }
                         }
                     } while (!found);
                     add(ch, new RectF((float) start / width, (float) line / bitmap.getHeight(), (float) separator / width, (float) line / bitmap.getHeight() + vHeight));
                     separator++;
                 }
             }
             lineHeight = baseLine = height(frames.get(chars.charAt(0)));
         }
}