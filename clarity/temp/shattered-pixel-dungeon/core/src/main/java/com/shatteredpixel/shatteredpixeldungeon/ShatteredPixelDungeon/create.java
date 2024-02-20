class Snippet {
  public void create(){
      super.create();
      updateSystemUI();
      SPDAction.loadBindings();
      Music.INSTANCE.enable(SPDSettings.music());
      Music.INSTANCE.volume(SPDSettings.musicVol() * SPDSettings.musicVol() / 100f);
      Sample.INSTANCE.enable(SPDSettings.soundFx());
      Sample.INSTANCE.volume(SPDSettings.SFXVol() * SPDSettings.SFXVol() / 100f);
      Sample.INSTANCE.load(Assets.Sounds.all);
  }
}