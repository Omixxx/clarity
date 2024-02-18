class Snippet {
  public void reloadGenerators(){
      if (packer != null) {
          for (FreeTypeFontGenerator generator : fonts.keySet()) {
              for (BitmapFont f : fonts.get(generator).values()) {
                  f.dispose();
              }
              fonts.get(generator).clear();
          }
          if (packer != null) {
              for (PixmapPacker.Page p : packer.getPages()) {
                  p.getTexture().dispose();
              }
              packer.dispose();
          }
          packer = new PixmapPacker(pageSize, pageSize, Pixmap.Format.RGBA8888, 1, false);
      }
  }

}