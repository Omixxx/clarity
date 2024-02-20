class Snippet {
     public static synchronized void addIfExisting(PointerEvent event){
         if (activePointers.containsKey(event.id)) {
             pointerEvents.add(event);
         }
     }
}