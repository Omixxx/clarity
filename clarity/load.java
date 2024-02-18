class Snippet {
     public synchronized void load(final String... assets){
         for (String asset : assets) {
             if (!ids.containsKey(asset) && !loadingQueue.contains(asset)) {
                 loadingQueue.add(asset);
             }
         }
         //cancel if all assets are already loaded
         if (loadingQueue.isEmpty())
             return;
         //load one at a time on the UI thread to prevent this blocking the UI
         //yes this may cause hitching, but only in the first couple seconds of game runtime
         Game.runOnRenderThread(loadingCallback);
     }

}