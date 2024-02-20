class Snippet {
   protected void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
       try {
           GdxNativesLoader.load();
           FreeType.initFreeType();
       } catch (Exception e) {
           AndroidMissingNativesHandler.errorMsg = e.getMessage();
           Intent intent = new Intent(this, AndroidMissingNativesHandler.class);
           startActivity(intent);
           finish();
           return;
       }
       //there are some things we only need to set up on first launch
       if (instance == null) {
           instance = this;
           try {
               Game.version = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
           } catch (PackageManager.NameNotFoundException e) {
               Game.version = "???";
           }
           try {
               Game.versionCode = getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
           } catch (PackageManager.NameNotFoundException e) {
               Game.versionCode = 0;
           }
           if (UpdateImpl.supportsUpdates()) {
               Updates.service = UpdateImpl.getUpdateService();
           }
           if (NewsImpl.supportsNews()) {
               News.service = NewsImpl.getNewsService();
           }
           FileUtils.setDefaultFileProperties(Files.FileType.Local, "");
           // grab preferences directly using our instance first
           // so that we don't need to rely on Gdx.app, which isn't initialized yet.
           // Note that we use a different prefs name on android for legacy purposes,
           // this is the default prefs filename given to an android app (.xml is automatically added to it)
           SPDSettings.set(instance.getPreferences("ShatteredPixelDungeon"));
       } else {
           instance = this;
       }
       //set desired orientation (if it exists) before initializing the app.
       if (SPDSettings.landscape() != null) {
           instance.setRequestedOrientation(SPDSettings.landscape() ? ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE : ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);
       }
       AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
       config.depth = 0;
       if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
           //use rgb565 on ICS devices for better performance
           config.r = 5;
           config.g = 6;
           config.b = 5;
       }
       //we manage this ourselves
       config.useImmersiveMode = false;
       config.useCompass = false;
       config.useAccelerometer = false;
       if (support == null)
           support = new AndroidPlatformSupport();
       else
           support.reloadGenerators();
       support.updateSystemUI();
       Button.longClick = ViewConfiguration.getLongPressTimeout() / 1000f;
       initialize(new ShatteredPixelDungeon(support), config);
   }
}