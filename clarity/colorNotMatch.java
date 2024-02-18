class Snippet {
         private boolean colorNotMatch(Pixmap pixmap, int x, int y, int color){
             int pixel = pixmap.getPixel(x, y);
             if ((pixel & 0xFF) == 0) {
                 return color != 0;
             }
             return pixel != color;
         }

}