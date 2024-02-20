class Snippet {
   public void onFullBackup(FullBackupDataOutput data){
       //fully overrides super.onFullBackup, meaning only files specified here are backed up
       //does not backup runs in progress, to prevent cheating.
       //store shared preferences
       fullBackupFile(new File(getFilesDir().getParent() + "/shared_prefs/ShatteredPixelDungeon.xml"), data);
       //store game data
       File file = getFile(getFilesDir(), Rankings.RANKINGS_FILE);
       if (file != null) {
           fullBackupFile(file, data);
       }
       file = getFile(getFilesDir(), Badges.BADGES_FILE);
       if (file != null) {
           fullBackupFile(file, data);
       }
       file = getFile(getFilesDir(), Journal.JOURNAL_FILE);
       if (file != null) {
           fullBackupFile(file, data);
       }
   }
}