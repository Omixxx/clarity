class Snippet {
    public static void clear(String layerName){
        if (layers.containsKey(layerName)) {
            layers.get(layerName).clear();
            layers.remove(layerName);
        }
    }
}