class Snippet {
  protected void onResume(){
      //prevents weird rare cases where the app is running twice
      if (instance != this) {
          if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
              finishAndRemoveTask();
          } else {
              finish();
          }
      }
      super.onResume();
  }
}