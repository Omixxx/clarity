class Snippet {
   protected void emit(int index){
       RectF frame = ((Image) target).frame();
       float ofsX = frame.left * mapW;
       float ofsY = frame.top * mapH;
       float x, y;
       do {
           x = Random.Float(frame.width()) * mapW;
           y = Random.Float(frame.height()) * mapH;
       } while ((map.bitmap.getPixel((int) (x + ofsX), (int) (y + ofsY)) & 0x000000FF) == 0);
       factory.emit(this, index, target.x + x * target.scale.x, target.y + y * target.scale.y);
   }
}