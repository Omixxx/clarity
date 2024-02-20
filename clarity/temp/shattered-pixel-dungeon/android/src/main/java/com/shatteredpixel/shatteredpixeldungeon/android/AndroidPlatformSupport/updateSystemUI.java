class Snippet {
  public void updateSystemUI(){
      AndroidLauncher.instance.runOnUiThread(new Runnable() {
  
          @SuppressLint("NewApi")
          @Override
          public void run() {
              boolean fullscreen = Build.VERSION.SDK_INT < Build.VERSION_CODES.N || !AndroidLauncher.instance.isInMultiWindowMode();
              if (fullscreen) {
                  AndroidLauncher.instance.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN | WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
              } else {
                  AndroidLauncher.instance.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN | WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
              }
              if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                  if (SPDSettings.fullscreen()) {
                      AndroidLauncher.instance.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
                  } else {
                      AndroidLauncher.instance.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                  }
              }
          }
      });
  }
}