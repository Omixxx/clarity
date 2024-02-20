class Snippet {
     public void map(int[] data, int cols){
         this.data = data;
         mapWidth = cols;
         mapHeight = data.length / cols;
         size = mapWidth * mapHeight;
         width = cellW * mapWidth;
         height = cellH * mapHeight;
         quads = Quad.createSet(size);
         updateMap();
     }
}