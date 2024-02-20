class Snippet {
      public static void setCustomCursor(Type type, int zoom){
          //custom cursors (i.e. images which replace the mouse icon) are only supported on desktop
          if (!DeviceCompat.isDesktop()) {
              return;
          }
          if (currentCursor != null) {
              if (lastType == type && lastZoom == zoom) {
                  return;
              }
              currentCursor.dispose();
              currentCursor = null;
          }
          Pixmap cursorImg = new Pixmap(FileUtils.getFileHandle(Files.FileType.Internal, type.file));
          int scaledWidth = cursorImg.getWidth() * zoom;
          int width2 = 2;
          while (width2 < scaledWidth) {
              width2 <<= 1;
          }
          int scaledHeight = cursorImg.getHeight() * zoom;
          int height2 = 2;
          while (height2 < scaledHeight) {
              height2 <<= 1;
          }
          Pixmap scaledImg = new Pixmap(width2, height2, cursorImg.getFormat());
          scaledImg.setFilter(Pixmap.Filter.NearestNeighbour);
          scaledImg.drawPixmap(cursorImg, 0, 0, cursorImg.getWidth(), cursorImg.getHeight(), 0, 0, scaledWidth, scaledHeight);
          currentCursor = Gdx.graphics.newCursor(scaledImg, 0, 0);
          Gdx.graphics.setCursor(currentCursor);
          scaledImg.dispose();
          cursorImg.dispose();
          lastType = type;
          lastZoom = zoom;
      }
}