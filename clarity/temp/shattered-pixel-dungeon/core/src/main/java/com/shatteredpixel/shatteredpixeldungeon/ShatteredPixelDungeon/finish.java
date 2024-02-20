class Snippet {
  public void finish(){
      if (!DeviceCompat.isiOS()) {
          super.finish();
      } else {
          //can't exit on iOS (Apple guidelines), so just go to title screen
          switchScene(TitleScene.class);
      }
  }
}