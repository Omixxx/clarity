class Snippet {
  protected void layout(){
      super.layout();
      float contX = x;
      float contY = y;
      float contW = width;
      float contH = height;
      if (bg != null) {
          bg.x = x;
          bg.y = y;
          bg.size(width, height);
          contX += bg.marginLeft();
          contY += bg.marginTop();
          contW -= bg.marginHor();
          contH -= bg.marginVer();
      }
      float zoom = Camera.main.zoom;
      Camera c = camera();
      if (c != null) {
          zoom = c.zoom;
          Point p = c.cameraToScreen(contX, contY);
          contX = p.x / zoom;
          contY = p.y / zoom;
      }
      container.align(Align.topLeft);
      container.setPosition(contX * zoom, (Game.height - (contY * zoom)));
      container.size(contW * zoom, contH * zoom);
  }
}