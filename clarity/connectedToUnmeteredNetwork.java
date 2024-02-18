class Snippet {
  public boolean connectedToUnmeteredNetwork(){
      //Returns true if using unmetered connection, use shortcut method if available
      ConnectivityManager cm = (ConnectivityManager) AndroidLauncher.instance.getSystemService(Context.CONNECTIVITY_SERVICE);
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
          return !cm.isActiveNetworkMetered();
      } else {
          NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
          return activeNetwork != null && activeNetwork.isConnectedOrConnecting() && (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI || activeNetwork.getType() == ConnectivityManager.TYPE_WIMAX || activeNetwork.getType() == ConnectivityManager.TYPE_BLUETOOTH || activeNetwork.getType() == ConnectivityManager.TYPE_ETHERNET);
      }
  }

}