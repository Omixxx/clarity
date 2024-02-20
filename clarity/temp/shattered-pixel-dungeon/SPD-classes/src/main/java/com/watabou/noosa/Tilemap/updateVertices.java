class Snippet {
  protected void updateVertices(){
      moveToUpdating();
      float x1, y1, x2, y2;
      int pos;
      RectF uv;
      y1 = cellH * updating.top;
      y2 = y1 + cellH;
      for (int i = updating.top; i < updating.bottom; i++) {
          x1 = cellW * updating.left;
          x2 = x1 + cellW;
          pos = i * mapWidth + updating.left;
          for (int j = updating.left; j < updating.right; j++) {
              if (topLeftUpdating == -1)
                  topLeftUpdating = pos;
              bottomRightUpdating = pos + 1;
              ((Buffer) quads).position(pos * 16);
              uv = tileset.get(data[pos]);
              if (needsRender(pos) && uv != null) {
                  vertices[0] = x1;
                  vertices[1] = y1;
                  vertices[2] = uv.left;
                  vertices[3] = uv.top;
                  vertices[4] = x2;
                  vertices[5] = y1;
                  vertices[6] = uv.right;
                  vertices[7] = uv.top;
                  vertices[8] = x2;
                  vertices[9] = y2;
                  vertices[10] = uv.right;
                  vertices[11] = uv.bottom;
                  vertices[12] = x1;
                  vertices[13] = y2;
                  vertices[14] = uv.left;
                  vertices[15] = uv.bottom;
              } else {
                  //If we don't need to draw this tile simply set the quad to size 0 at 0, 0.
                  // This does result in the quad being drawn, but we are skipping all
                  // pixel-filling. This is better than fully skipping rendering as we
                  // don't need to manage a buffer of drawable tiles with insertions/deletions.
                  Arrays.fill(vertices, 0);
              }
              quads.put(vertices);
              pos++;
              x1 = x2;
              x2 += cellW;
          }
          y1 = y2;
          y2 += cellH;
      }
  }
}