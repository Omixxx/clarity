class Snippet {
  public void draw(){
      if (lightMode) {
          Blending.setLightMode();
          super.draw();
          Blending.setNormalMode();
      } else {
          super.draw();
      }
  }
}