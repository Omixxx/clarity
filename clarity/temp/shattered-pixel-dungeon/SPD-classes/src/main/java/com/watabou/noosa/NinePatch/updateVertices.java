class Snippet {
  protected void updateVertices(){
      ((Buffer) quads).position(0);
      float right = width - marginRight;
      float bottom = height - marginBottom;
      float outleft = flipHorizontal ? outterF.right : outterF.left;
      float outright = flipHorizontal ? outterF.left : outterF.right;
      float outtop = flipVertical ? outterF.bottom : outterF.top;
      float outbottom = flipVertical ? outterF.top : outterF.bottom;
      float inleft = flipHorizontal ? innerF.right : innerF.left;
      float inright = flipHorizontal ? innerF.left : innerF.right;
      float intop = flipVertical ? innerF.bottom : innerF.top;
      float inbottom = flipVertical ? innerF.top : innerF.bottom;
      Quad.fill(vertices, 0, marginLeft, 0, marginTop, outleft, inleft, outtop, intop);
      quads.put(vertices);
      Quad.fill(vertices, marginLeft, right, 0, marginTop, inleft, inright, outtop, intop);
      quads.put(vertices);
      Quad.fill(vertices, right, width, 0, marginTop, inright, outright, outtop, intop);
      quads.put(vertices);
      Quad.fill(vertices, 0, marginLeft, marginTop, bottom, outleft, inleft, intop, inbottom);
      quads.put(vertices);
      Quad.fill(vertices, marginLeft, right, marginTop, bottom, inleft, inright, intop, inbottom);
      quads.put(vertices);
      Quad.fill(vertices, right, width, marginTop, bottom, inright, outright, intop, inbottom);
      quads.put(vertices);
      Quad.fill(vertices, 0, marginLeft, bottom, height, outleft, inleft, inbottom, outbottom);
      quads.put(vertices);
      Quad.fill(vertices, marginLeft, right, bottom, height, inleft, inright, inbottom, outbottom);
      quads.put(vertices);
      Quad.fill(vertices, right, width, bottom, height, inright, outright, inbottom, outbottom);
      quads.put(vertices);
      dirty = true;
  }
}