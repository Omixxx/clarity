class Snippet {
   public synchronized int numListeners(){
       return listeners.size();
   }
}