class Snippet {
     public Image image(int x, int y){
         if (!needsRender(x + mapWidth * y)) {
             return null;
         } else {
             Image img = new Image(texture);
             img.frame(tileset.get(data[x + mapWidth * y]));
             return img;
         }
     }

}